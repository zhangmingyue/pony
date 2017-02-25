package com.pony.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping("/test")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name","qiaoyi");
        return "helloWorld";
    }
}