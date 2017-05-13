package com.pony.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.MobileInterface.entity.Stock;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.MobileInterface.service.ProductForMobileService;
import com.pony.MobileInterface.service.ProductOrderForMobileService;
import com.pony.domain.AddressEntity;
import com.pony.domain.ShoppingCartEntry;
import com.pony.productManage.entity.Product;
import com.pony.service.AddressService;
import com.pony.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/20
 */
@Controller
@RequestMapping(value = "/shopping_cart")
public class ShoppingCartController {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
    private final int DEFAULT_COUNT = 1;

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductForMobileService productForMobileService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ProductOrderForMobileService productOrderForMobileService;

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

        AddressEntity addressEntity = addressService.getAddressById(Integer.parseInt(addressIdStr));
        log.info("shoppingCartAdd addressEntity={}", addressEntity);
        int cabinetId = -1;
        int stock = -1;
        if (addressEntity != null) {
            cabinetId = addressEntity.getSelfLiftingCabinet();
            int warehorseId = addressEntity.getWarehouseId();
            int productId = Integer.parseInt(id);
            Stock stockEntity = productOrderForMobileService.
                    getStockByWarehouseIdAndProductId(warehorseId, productId);
            log.info("shoppingCartAdd warhouseId={},id={} stockEntity={}",
                    warehorseId, productId, stockEntity);
            if (stockEntity != null) {
                log.info("stockEntity={}", stockEntity.toString());
                log.info("test={}", stockEntity.getInventory());
                stock = stockEntity.getId();
            }
        }

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

        List<ShoppingCartEntry> shoppingCartEntryList =
                shoppingCartService.getShoppingCartEntityByPhone(phone);

        List<ShoppingCartEntry> shoppingCartEntryList2 = new ArrayList<>();

        if (shoppingCartEntryList != null) {
            ProductQueryBean productQueryBean = new ProductQueryBean();
            for (ShoppingCartEntry shoppingCartEntry : shoppingCartEntryList) {
                int productId = shoppingCartEntry.getProductId();
                if (productId > 0) {
                    productQueryBean.setProductId(productId);
                    Product product = productForMobileService.
                            getProductAndProductPictureById(productQueryBean);
                    int surplus = productOrderForMobileService.getInventoryByStockId(shoppingCartEntry.getStock());
                    shoppingCartEntry.setProduct(product);
                    shoppingCartEntry.setSurplus(surplus);
                    shoppingCartEntryList2.add(shoppingCartEntry);
                }
            }

            List<ShoppingCartEntry> spot = new ArrayList<>();
            List<ShoppingCartEntry> reservation = new ArrayList<>();

            for (ShoppingCartEntry shoppingCartEntry : shoppingCartEntryList2) {
                Product product = shoppingCartEntry.getProduct();
                if (product != null && product.getReservationId() == 0) {
                    spot.add(shoppingCartEntry);
                } else {
                    reservation.add(shoppingCartEntry);
                }
            }

            result.put("result", true);
            result.put("spot", spot);
            result.put("reservation", reservation);
            return result;
        }

        result.put("msg", 1);
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject delete(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String id = request.getParameter("id");
        if (Strings.isNullOrEmpty(id)) {
            result.put("code", 0);
            return result;
        }

        boolean deleteById = shoppingCartService.deleteById(Integer.parseInt(id));
        if (deleteById) {
            result.put("result", true);
            result.put("code", 200);
            return result;
        }

        result.put("code", 1);
        return result;
    }

    @RequestMapping(value = "/delete_list", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSONObject delete(@RequestBody JSONObject request) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        JSONArray idList = request.getJSONArray("idList");

        if (idList != null && idList.isEmpty()) {
            result.put("code", 0);
            return result;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        if (idList != null) {
            for (int i = 0; i < idList.size(); i++) {
                boolean deleteById = shoppingCartService.deleteById(idList.getIntValue(i));
                map.put(i, deleteById);
            }
        }
        result.put("data", map);
        result.put("code", 200);
        return result;
    }
}
