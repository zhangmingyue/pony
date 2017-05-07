package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.pony.domain.CategoryEntity;
import com.pony.service.CategoryService;
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
 * @created:17/5/7
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "get_all_fresh", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getCategoryLevel3(HttpServletRequest request,
                                        HttpServletResponse response) {
        JSONObject result = new JSONObject();
        List<String> categoryEntities = categoryService.getCategoryByIsFresh();
        result.put("result", 200);
        result.put("date", categoryEntities);
        return result;
    }
}
