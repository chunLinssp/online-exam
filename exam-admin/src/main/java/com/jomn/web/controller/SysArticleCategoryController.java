package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.domain.ArticleCategory;
import com.jomn.service.SysArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysArticleCategoryController {

    @Autowired
    SysArticleCategoryService sysArticleCategoryService;

    @GetMapping("/system/articleCategoryView")
    @ResponseBody
    public Result articleCategoryView(ArticleCategory articleCategory) {
        List<ArticleCategory> articleCategories = sysArticleCategoryService.selectCategoryList(articleCategory);
        Result success = ResultHandle.success(articleCategories);
        return success;
    }







}
