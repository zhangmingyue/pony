package com.pony.service.Impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.pony.dao.CategoryDAO;
import com.pony.domain.CategoryEntity;
import com.pony.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO category;

    private static Cache<Integer, List<String>> categoryCache = CacheBuilder.newBuilder()
            .expireAfterAccess(6, TimeUnit.HOURS)
            .build();

    private static List<String> getCategoryList() {
        try {
            if (categoryCache != null) {
                return categoryCache.getIfPresent(1);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    @Override
    public List<CategoryEntity> getCategoryByType(String type) {
        return category.getCategoryByType(type);
    }

    @Override
    public List<CategoryEntity> getCategoryByParent(String parent) {
        return category.getCategoryByParent(parent);
    }

    @Override
    public List<String> getCategoryByIsFresh() {
        return category.getCategoryByIsFresh();
    }
}
