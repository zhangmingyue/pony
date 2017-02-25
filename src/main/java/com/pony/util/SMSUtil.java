package com.pony.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * https://help.aliyun.com/document_detail/50119.html?spm=5176.doc44363.6.576.6GQa5j
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/15
 */
@Component("smsUtil")
public class SMSUtil {

    //key管理 https://ak-console.aliyun.com/?spm=5176.doc44366.2.1.DnKMUE#/accesskey
    private static final String ACCESS_KEY_ID = "LTAIWJwgxakkV5n3";
    private static final String ACCESS_KEY_SECRET = "YLwNLhTpKAD6Mhvml136RgFW19Jh1V";

    /**
     * 用于短信服务
     *
     * @param phoneNum     接收号码
     * @param signName     控制台创建的签名名称
     * @param templateCode 控制台创建的模板CODE
     * @param templateVar  短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。"
     *                     ___________________________________________________________________________________
     *                     错误返回代码: 200成功, 500调用接口出现异常,501参数不完整
     */
    public Map<String, String> sendSMS(String phoneNum, String signName, String templateCode, String templateVar) {
        try {
            Map<String, String> result = new HashMap<>();
            if (Strings.isNullOrEmpty(phoneNum) ||
                    Strings.isNullOrEmpty(signName) ||
                    Strings.isNullOrEmpty(templateCode) ||
                    Strings.isNullOrEmpty(templateCode)) {
                result.put("code", "501");
            }

            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
            IAcsClient client = new DefaultAcsClient(profile);
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(signName);//控制台创建的签名名称
            request.setTemplateCode(templateCode);//控制台创建的模板CODE
            request.setParamString("{\"code\":\"" + templateVar + "\",\"product\":\"小马自提\"}");

            request.setRecNum(phoneNum);
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
            //前期先不做是否送达的操作了,保留检查送达参数model,requestId
            String model = httpResponse.getModel();
            String requestId = httpResponse.getRequestId();

            result.put("code", "200");
            result.put("model", model);
            result.put("requestId", requestId);
            return result;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
