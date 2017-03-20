package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Controller
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject shoppingCartAdd(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject shoppingCartGet(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        return result;
    }
}
