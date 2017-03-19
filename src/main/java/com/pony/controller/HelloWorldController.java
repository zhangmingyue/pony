package com.pony.controller;

import com.pony.service.Impl.AlibabaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AlibabaService alibabaService;


    @PostConstruct
    public void test() {
        logger.info("info test ");
        logger.error("error test");
    }

    @GetMapping("/test")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name", "qiaoyi");
        return "helloWorld";
    }
}