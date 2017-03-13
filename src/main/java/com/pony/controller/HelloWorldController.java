package com.pony.controller;

import com.alipay.api.AlipayApiException;
import com.pony.service.Impl.AlibabaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @Autowired
    AlibabaService alibabaService;


    @PostConstruct
    public void test() {
        try {
            alibabaService.pay();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/test")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name", "qiaoyi");
        return "helloWorld";
    }
}