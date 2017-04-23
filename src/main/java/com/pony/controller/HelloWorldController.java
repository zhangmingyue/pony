package com.pony.controller;

import com.pony.domain.TestEntry;
import com.pony.service.Impl.AlibabaService;
import com.pony.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * @author: qiaoyi
 * @edit:
 * @created:17/2/23
 */
//@Controller
//@RequestMapping("/")
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AlibabaService alibabaService;
    @Autowired
    RedisUtil redisUtil;


    @PostConstruct
    public void test() {
//        TestEntry testEntry = new TestEntry();
//        testEntry.setTep("qiaoyi_test_redis");
//        testEntry.setId(12);
//        testEntry.setTest("qiaoyi_dhfasdhakjdhjak");
//
//        String test = redisUtil.setObject("qiaoyi", testEntry);
//        logger.info("HelloWorldController test={}", test);
//        Object object = redisUtil.getObject("qiaoyi");
//        logger.info("HelloWorldController object", object.toString());
    }

    @GetMapping("/test")
    String index(Model model) {
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("name", "qiaoyi");
        return "helloWorld";
    }
}