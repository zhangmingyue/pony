package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.SystemMessage;
import com.pony.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/30
 */
@Controller
@RequestMapping(value = "system_message")
public class SystemMessageController {
    @Autowired
    SystemMessageService systemMessageService;

    @RequestMapping(value = "/get_system_message_by_phone", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getSystemMessage(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String phone = request.getParameter("phone");
        if (Strings.isNullOrEmpty(phone)) {
            result.put("code", 0);
            return result;
        }
        List<SystemMessage> systemMessages = systemMessageService.getSystemMessageByPhone(phone);
        result.put("result", true);
        result.put("data", systemMessages);
        result.put("code", 200);
        return result;
    }
}
