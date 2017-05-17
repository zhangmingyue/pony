package com.pony.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import com.pony.MobileInterface.service.ProductOrderForMobileService;
import com.pony.domain.RefundEntry;
import com.pony.service.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Controller
@RequestMapping(value = "/refund")
public class RefundController {
    private static final Logger log = LoggerFactory.getLogger(RefundController.class);

    @Autowired
    RefundService refundService;
    @Autowired
    ProductOrderForMobileService productOrderForMobileService;

    @RequestMapping(value = "/get_list", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getRefundList(ChildOrderQueryBean childOrderQueryBean) {
        JSONObject result = new JSONObject();
        childOrderQueryBean.setTimeFilter(1);
        List<ChildOrder> childOrderList = productOrderForMobileService.getChildOrderByQueryBean(childOrderQueryBean);
        result.put("childOrderList", childOrderList);
        return result;
    }

    /**
     * 申请售后接口
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/apply", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSONObject applyRefund(@RequestBody JSONObject request) {
        String phone = request.getString("phone");
        String orderId = request.getString("order_id");
        //退货原因
        String reason = request.getString("reason");
        //留言说明
        String message = request.getString("message");
        //pic
        JSONArray pic = request.getJSONArray("pic");
        JSONObject product = request.getJSONObject("product");
        String productId = product.getString("product_id");
        int number = Integer.parseInt(product.getString("number"));
        String pic1 = null;
        String pic2 = null;
        String pic3 = null;
        if (pic != null && pic.size() >= 1) {
            pic1 = pic.getString(0);
            pic2 = pic.size() >= 2 ? pic.getString(1) : null;
            pic3 = pic.size() == 3 ? pic.getString(2) : null;
        }

        JSONObject result = new JSONObject();
        result.put("result", false);
        if (Strings.isNullOrEmpty(phone) || Strings.isNullOrEmpty(orderId)
                || Strings.isNullOrEmpty(reason)
                || Strings.isNullOrEmpty(productId)
                || number <= 0) {
            result.put("msg", 1);
            return result;
        }

        // TODO: 订单中商品价格的验证
        Date date = new Date(System.currentTimeMillis());
        RefundEntry refundEntry = new RefundEntry();
        refundEntry.setPhone(phone);
        refundEntry.setMessage(message);
        refundEntry.setNumber(number);
        refundEntry.setOrderId(orderId);
        refundEntry.setReason(reason);
        refundEntry.setPic1(pic1);
        refundEntry.setPic2(pic2);
        refundEntry.setPic3(pic3);
        refundEntry.setProductId(productId);
        refundEntry.setDate(date);

        if (refundService.insert(refundEntry) >= 1) {
            result.put("result", true);
            result.put("msg", 200);
            return result;
        }

        result.put("msg", 2);
        return result;
    }

    @RequestMapping(value = "cancel", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getDistrict(HttpServletRequest request,
                                  HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String id = request.getParameter("id");
        if (Strings.isNullOrEmpty(id)) {
            result.put("code", 0);
            return result;
        }

        if (refundService.updateStatusById(Integer.parseInt(id), 0) >= 1) {
            result.put("result", true);
            result.put("code", 200);
            return result;
        }

        result.put("code", 1);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JSONObject handleException(HttpServletRequest request, Exception ex) {
        try {
            log.error("RefundController handleException uri={} method={} exception={}"
                    , request.getRequestURI(), request.getMethod(), ex);
        } catch (Exception e) {
            log.error("RefundController handleException ex={}", e);
        }
        JSONObject result = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("result", false);
        data.put("msg", "exception");
        result.put("data", data);
        return result;
    }
}
