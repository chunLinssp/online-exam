package com.jomn.service.impl;

import com.jomn.domain.ArticleCategory;
import com.jomn.mapper.SysArticleCategoryMapper;
import com.jomn.service.SysArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysArticleCategoryServiceImpl implements SysArticleCategoryService {

    @Autowired
    SysArticleCategoryMapper sysArticleCategoryMapper;

    @Override
    public void updateArticleCategoryById(ArticleCategory articleCategory) {
        sysArticleCategoryMapper.updateArticleCategoryById(articleCategory);
    }

    @Override
    public void insertArticleCategory(ArticleCategory articleCategory) {
        sysArticleCategoryMapper.insertArticleCategory(articleCategory);
    }

    @Override
    public void delteArticleCategoryById(Integer id) {
        sysArticleCategoryMapper.delteArticleCategoryById(id);
    }

    @Override
    public void delteArticleCategoryList(Integer[] ids) {
        sysArticleCategoryMapper.delteArticleCategoryList(ids);
    }

    @Override
    public List<ArticleCategory> selectCategoryList(ArticleCategory articleCategory) {
        List<ArticleCategory> articleCategories = sysArticleCategoryMapper.selectCategoryList(articleCategory);
        return articleCategories;
    }


}
