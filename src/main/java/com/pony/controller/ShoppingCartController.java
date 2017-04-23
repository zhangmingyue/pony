package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.domain.ShoppingCartEntry;
import com.pony.service.ShoppingCartService;
import com.pony.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Controller
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {

    private final int DEFAULT_COUNT = 1;

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 1.根据手机号、商品id和地址看数据库中是否有相应的商品
     * 2.没有的话直接存entity
     * 3.有的话(地址、手机号、商品id全部符合,只加商品数量)
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject shoppingCartAdd(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");
        String countStr = request.getParameter("count");
        String addressIdStr = request.getParameter("addressId");
        String typeStr = request.getParameter("type");

        JSONObject result = new JSONObject();
        if (Strings.isNullOrEmpty(id) || Strings.isNullOrEmpty(phone) ||
                Strings.isNullOrEmpty(countStr) || Strings.isNullOrEmpty(addressIdStr) ||
                Strings.isNullOrEmpty(typeStr)) {
            result.put("result", false);
            result.put("phone", phone);
            result.put("msg", 0);
            return result;
        }
        int count = Integer.parseInt(countStr);

        ShoppingCartEntry shoppingCartEntry = shoppingCartService.
                getShoppingCartEntryByPhoneAndProductIdAndAddress
                        (phone, Integer.parseInt(id), Integer.parseInt(addressIdStr));

        Date time = new Date();

        //todo 教主给stock service
        int stock = 123;
        // TODO: 教主给柜子 id
        int cabinetId = 456;

        //数据库中没有用户和商品信息
        if (shoppingCartEntry == null) {
            ShoppingCartEntry shoppingCartEntry1 = new ShoppingCartEntry();
            shoppingCartEntry1.setPhone(phone);
            shoppingCartEntry1.setProductId(Integer.parseInt(id));
            shoppingCartEntry1.setCount(DEFAULT_COUNT);
            shoppingCartEntry1.setTime(time);
            shoppingCartEntry1.setAddressId(Integer.parseInt(addressIdStr));
            shoppingCartEntry1.setCabinetId(cabinetId);
            shoppingCartEntry1.setType(Integer.parseInt(typeStr));
            shoppingCartEntry1.setStock(stock);

            if (shoppingCartService.insert(shoppingCartEntry1) >= 1) {
                result.put("result", true);
                result.put("phone", phone);
                result.put("msg", 200);
                return result;
            }
        } else {
            //数据库中有用户信息
            int countDatabase = shoppingCartEntry.getCount() + count;
            shoppingCartEntry.setCount(countDatabase);

            if (shoppingCartService.updateByPhoneAndProduct(count, phone, Integer.parseInt(id)) >= 1) {
                result.put("result", true);
                result.put("phone", phone);
                result.put("msg", 200);
                return result;
            }
        }

        result.put("result", false);
        result.put("phone", phone);
        result.put("msg", 1);
        return result;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject shoppingCartGet(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String phone = request.getParameter("phone");

        if (Strings.isNullOrEmpty(phone)) {
            result.put("msg", 0);
            return result;
        }
        return result;
    }
}
