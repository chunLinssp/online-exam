package com.jomn.service;

import com.jomn.domain.ArticleCategory;

import java.util.List;

public interface SysArticleCategoryService {

    /**
     * 修改分类内容
     */
    public void updateArticleCategoryById(ArticleCategory articleCategory);

    /**
     * 增加分类内容
     */
    public void insertArticleCategory(ArticleCategory articleCategory);

    /**
     * 删除分类内容
     */
    public void delteArticleCategoryById(Integer id);

    /**
     * 删除多个分类内容
     */
    public void delteArticleCategoryList(Integer[] ids);

    /**
     * 查询所有分类内容
     */
    public List<ArticleCategory> selectCategoryList(ArticleCategory articleCategory);




}
