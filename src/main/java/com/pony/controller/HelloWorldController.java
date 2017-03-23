package com.pony.controller;

import com.pony.service.Impl.AlibabaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

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
        String host = "xx.kvstore.aliyuncs.com";//控制台显示访问地址
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        //鉴权信息
        jedis.auth("password");//password
        String key = "redis";
        String value = "aliyun-redis";
        //select db默认为0
        jedis.select(1);
        //set一个key
        jedis.set(key, value);
        System.out.println("Set Key " + key + " Value: " + value);
        //get 设置进去的key
        String getvalue = jedis.get(key);
        System.out.println("Get Key " + key + " ReturnValue: " + getvalue);
        jedis.quit();
        jedis.close();
    }

    @GetMapping("/test")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name", "qiaoyi");
        return "helloWorld";
    }
}