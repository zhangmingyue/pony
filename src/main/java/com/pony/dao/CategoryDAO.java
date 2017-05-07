package com.pony.dao;

import com.pony.domain.CategoryEntity;

import java.util.List;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/3/3
 */
public interface CategoryDAO {

    List<CategoryEntity> getCategoryByType(String type);

    List<CategoryEntity> getCategoryByParent(String parent);

    List<String> getCategoryByIsFresh();
}
