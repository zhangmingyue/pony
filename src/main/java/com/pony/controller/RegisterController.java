package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.pony.domain.TestEntry;
import com.pony.service.Impl.TestServiceImpl;
import com.pony.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/12
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public JSONObject test() {

        List<TestEntry> service = testService.getAllTest();
        JSONObject test = new JSONObject();
        test.put("qiaoyi", "qiaoyi");
        test.put("test", service);
        return test;

    }
}
