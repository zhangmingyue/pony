package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.google.common.base.Strings;
import com.pony.enumeration.PayCode;
import com.pony.util.AlipayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * 包含支付、支付查询、异步通知、退款申请、退款查询
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/3/13
 */
@Controller
@RequestMapping(value = "/money")
public class PayController {
    private static final Logger log = LoggerFactory.getLogger(PayController.class);

    /**
     * 支付下单
     * https://doc.open.alipay.com/docs/doc.htm?spm=a219a.7386797.0.0.kcmlNk&treeId=193&articleId=105465&docType=1
     *
     * @param request
     * @param response
     * @param phone    手机号
     * @param cashNum  金额
     * @param mercId   商品订单号
     * @param callback
     * @return
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject orderPay(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(required = false)
                                       String phone,
                               Double cashNum,
                               String mercId,
                               String callback) throws AlipayApiException {
        log.info("PayController begin param phone={},cashNum={},mercId=", phone, cashNum, mercId);
        JSONObject result = new JSONObject();
        if (Strings.isNullOrEmpty(phone)) {
            result.put("result", false);
            result.put("phone", phone);
            result.put("msg", PayCode.PHONE_NULL);
            return result;
        }

        if (Strings.isNullOrEmpty(mercId)) {
            result.put("result", false);
            result.put("phone", phone);
            result.put("msg", PayCode.MECNUM);
            return result;
        }

        if (cashNum <= 0) {
            result.put("result", false);
            result.put("phone", phone);
            result.put("msg", PayCode.CRASH_INVALID);
            return result;
        }

        // TODO:  获取订单信息,核实订单信息
        AlipayClient alipayClient = AlipayUtil.getAlipayClient();

        AlipayTradeAppPayRequest requestStr = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        //(否)对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
        model.setBody("我是测试数据");
        //(是)商品的标题/交易标题/订单标题/订单关键字等
        model.setSubject("App支付测试Java");
        //(是)商户网站唯一订单号
        model.setOutTradeNo(mercId);
        //(否)设置未付款支付宝交易的超时时间，一旦超时，该笔交易就会自动被关闭。
        model.setTimeoutExpress("30m");
        //(是)订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
        model.setTotalAmount("0.01");
        //(是)销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
        model.setProductCode("QUICK_MSECURITY_PAY");
        requestStr.setBizModel(model);
        requestStr.setNotifyUrl("商户外网可以访问的异步地址");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse responseStr = alipayClient.sdkExecute(requestStr);
            //就是orderString 可以直接给客户端请求，无需再做处理。
            result.put("msg", responseStr.getBody());
            result.put("result", true);
            result.put("phone", phone);
            return result;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/receive_notify")
    @ResponseBody
    public String payCheck(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(required = false)
                                       String phone,
                               Double cashNum,
                               String mercId,
                               String callback) throws AlipayApiException, UnsupportedEncodingException {
        JSONObject json = new JSONObject();
        log.info("cashNum={},mercId={},callback={}",cashNum,mercId,callback);
        //获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        log.info("param={}",params);
        for (Object o : requestParams.keySet()) {
            String name = (String) o;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        log.info("after param={}  ",params);
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayUtil.ALIPAY_PUBLIC_KEY, AlipayUtil.CHARSET, AlipayUtil.SIGN_TYPE);
        if(signVerified){
            // TODO 验签成功后
            //按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
            return "success";
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            return "failure";
        }
    }
}
