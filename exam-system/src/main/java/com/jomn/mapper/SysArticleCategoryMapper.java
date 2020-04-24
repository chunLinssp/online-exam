package com.jomn.mapper;

import com.jomn.domain.ArticleCategory;
import com.jomn.domain.ArticleTag;

import java.util.List;

public interface SysArticleCategoryMapper {

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

    /**
     * 通过id查询
     */
    public ArticleCategory selectArticleCategoryById(Integer id);



}
