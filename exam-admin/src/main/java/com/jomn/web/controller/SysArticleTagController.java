package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.domain.Article;
import com.jomn.domain.ArticleTag;
import com.jomn.service.SysArticleService;
import com.jomn.service.SysArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysArticleTagController {

    @Autowired
    SysArticleTagService sysArticleTagService;

    @GetMapping("/system/articleTagView")
    @ResponseBody
    public Result artivleTagView(ArticleTag articleTag) {
        List<ArticleTag> articleTags = sysArticleTagService.selectTagList(articleTag);
        Result success = ResultHandle.success(articleTags);
        return success;
    }

//    @GetMapping("/system/articleTageView/{id}")
//    @ResponseBody
//    public Result articleTagViewSingle(@PathVariable("id") Integer id) {
//
//    }






}
