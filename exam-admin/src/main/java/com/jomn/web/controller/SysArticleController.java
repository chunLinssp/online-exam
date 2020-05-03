package com.jomn.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultCode;
import com.jomn.constant.api.ResultHandle;
import com.jomn.core.page.PageDomain;
import com.jomn.core.page.TableDataInfo;
import com.jomn.domain.*;
import com.jomn.service.SysArticleBodyService;
import com.jomn.service.SysArticleService;
import com.jomn.service.SysArticleTagService;
import com.jomn.web.core.vo.ArticleTableVo;
import com.jomn.web.core.vo.ArticleVo;
import com.jomn.web.core.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class SysArticleController extends BaseController{

    @Autowired
    SysArticleService sysArticleService;
    @Autowired
    SysArticleTagService sysArticleTagService;
    @Autowired
    SysArticleBodyService sysArticleBodyService;

    @RequestMapping(value = "/system/article",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    @FastJsonView(
            exclude = {
                @FastJsonFilter(clazz = SysUser.class,props = {"roleId","loginName","phonenumber","password","salt","status","delFlag","loginIp","loginDate","userType","roleIds","roles"}),
                @FastJsonFilter(clazz = Article.class,props = {"weight"})
            }
    )
    public PageVo articleView(PageDomain pageDomain, String categoryId ,@RequestBody(required = false) Article article) {
        if(categoryId != null) {
            ArticleCategory articleCategory = new ArticleCategory();
            articleCategory.setId(Integer.parseInt(categoryId));
            article.setArticleCategory(articleCategory);
        }
        startPage(pageDomain);
        List<Article> articles = sysArticleService.selectArticleList(article);
        PageVo pageVo = getPageVo(articles);
        return pageVo;

    }


//    @PostMapping("/system/article/edit")
//    @ResponseBody
//    public Result editMenu(Article article) {
//        sysArticleService.updateArticleStatusById(article);
//        return ResultHandle.success();
//    }

    @GetMapping("/system/UserArticleView")
    @ResponseBody
    public Result UserArticleView(String id) {
        List<Article> articles = sysArticleService.selectArticleListByUid(Long.parseLong(id));
        Result success = ResultHandle.success(articles);
        return success;
    }

    @PostMapping("/system/updateArticle")
    @ResponseBody
    public Result updateArticle(@RequestBody List<Article> article) {
        sysArticleService.updateArticleStatusById(article);
        Result success = ResultHandle.success();
        return success;
    }


    @PostMapping("/system/article/insert")
    @ResponseBody
    public Result insertMenu(SysMenu sysMenu) {
        Result success = ResultHandle.success();
        return success;
    }

    @GetMapping("/system/ArticleTagView")
    @ResponseBody
    public Result ArticleTagView(PageDomain pageDomain,Integer tagId) {
        startPage(pageDomain);
        List<Article> articles = sysArticleService.selectArticleByTagId(tagId);
        Result success = ResultHandle.success(articles);
        return success;
    }

    @PostMapping("/system/saveArticle")
    @ResponseBody
    public Result ArticleSavePicture( MultipartFile images) {
        String url = sysArticleService.saveArticlePicture(images);
        return ResultHandle.success(url);
    }

    @PostMapping("/system/saveArticleContent")
    @ResponseBody
    public Result saveArticleContent(HttpServletRequest request,@RequestBody  ArticleVo articleVo) {
        String header = request.getHeader("Oauth-token");
        loadArticleContent(header,articleVo);
        return ResultHandle.success();
    }


    public void loadArticleContent(String header,ArticleVo articleVo) {
        Article article = new Article();

        ArticleBody articleBody = new ArticleBody();
        articleBody.setContent(articleVo.getArticleBody());
        articleBody.setContentHtml(articleVo.getArticleBodyHtml());
        sysArticleBodyService.insertArticleBody(articleBody);
        article.setArticleBody(articleBody);

        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setId(articleVo.getCategoryId());
        article.setArticleCategory(articleCategory);


        article.setTitle(articleVo.getArticleTitle());
        article.setSummary(articleVo.getArticleSummary());
        article.setCreateTime(new Date());
        Article newArticle = sysArticleService.insertArticle(header, article);
        if(articleVo.getTagId().length != 0) {
            //保存文章tags
            sysArticleTagService.insertAricleTagTmp(newArticle.getId(),articleVo.getTagId());
        }

    }




    public List<ArticleTableVo> loadArticleTableData(List<Article> list) {
        List<ArticleTableVo> articleTableVos = new ArrayList<>();
        for (Article article : list) {
            ArticleTableVo articleTableVo = new ArticleTableVo();
            articleTableVo.setBodyId(article.getArticleBody().getId());
            articleTableVo.setCategoryName(article.getArticleCategory().getCategoryname());
            articleTableVo.setId(article.getId());
            articleTableVo.setStatus(article.getStatus());
            articleTableVo.setSummary(article.getSummary());
            articleTableVo.setTitle(article.getTitle());
            articleTableVos.add(articleTableVo);
        }
        return articleTableVos;
    }



}
