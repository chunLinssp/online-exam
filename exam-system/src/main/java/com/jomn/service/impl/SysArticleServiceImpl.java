package com.jomn.service.impl;

import com.jomn.domain.*;
import com.jomn.mapper.SysArticleBodyMapper;
import com.jomn.mapper.SysArticleMapper;
import com.jomn.mapper.SysUserMapper;
import com.jomn.service.SysArticleService;
import com.jomn.utlis.JWTUtil;
import com.jomn.utlis.PmsUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SysArticleServiceImpl implements SysArticleService {

    @Autowired
    SysArticleMapper sysArticleMapper;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysArticleBodyMapper sysArticleBodyMapper;


    @Override
    public void updateArticleStatusById(List<Article> article) {
        sysArticleMapper.updateArticleStatusById(article);
    }

    @Override
    public void delteArticleByIds(Integer[] ids) {
        sysArticleMapper.delteArticleByIds(ids);
    }

    @Override
    public List<Article> selectArticleListById(Long useId) {
        List<Article> articles = sysArticleMapper.selectArticleListById(useId);
        return articles;
    }


    @Override
    public List<Article> selectArticleList(Article article) {
        List<Article> articles = sysArticleMapper.selectArticleList(article);
//        List<Article> articleAllList = getArticleAllList(article);
        return articles;

    }

    @Override
    public Article insertArticle(String header, Article article) {
        String username = JWTUtil.getUsername(header);
        SysUser sysUser = sysUserMapper.selectUserByLoginName(username);
        article.setSysUser(sysUser);
        article.setCreateTime(new Date());
        sysArticleMapper.insertArticle(article);

        return article;
    }

    @Override
    public List<Article> selectArticleListByUid(Long id) {
        List<Article> articles = sysArticleMapper.selectArticleListByUid(id);
        return articles;
    }

//    @Override
//    public List<Article> selectArticleAllList(Map<String,Object> params) {
//        List<Article> articleAllList = getArticleAllList(params);
//        return articleAllList;
//    }

    @Override
    public List<Article> selectArticleByTagId(Integer id) {
        List<Article> articles = sysArticleMapper.selectArticleByTagId(id);
        return articles;
    }

    @Override
    public String saveArticlePicture(MultipartFile file) {
        String url = PmsUploadUtil.uploadImage(file);
        return url;
    }

    @Override
    public void saveArticleContent(String header, Article article) {
        String username = JWTUtil.getUsername(header);
        if(username != null ) {
            SysUser sysUser = sysUserMapper.selectUserByLoginName(username);
            article.setSysUser(sysUser);
            //插入文章内容
            ArticleBody articleBody = article.getArticleBody();
            sysArticleBodyMapper.insertArticleBody(articleBody);
            article.setArticleBody(articleBody);
            sysArticleMapper.insertArticle(article);
        }
    }

//    public List<Article> getArticleAllList(Article article) {
//        Map<String, Object> params = article.getParams();
//        if(params != null) {
//            String categoryId = (String)params.get("categoryId");
//            if(categoryId != null) {
//                ArticleCategory articleCategory = new ArticleCategory();
//                articleCategory.setId(Integer.parseInt(categoryId));
//                article.setArticleCategory(articleCategory);
//            }
//        }
//        List<Article> articles = sysArticleMapper.selectArticleList(article);
//        return articles;
//    }

//    public List<Article>  getArticleAllList(Map<String,Object> params) {
//        String category_id =(String) params.get("category_id");
//        Article article = new Article();
//        ArticleCategory articleCategory = new ArticleCategory();
//        if(category_id != null) {
//            articleCategory.setId(Integer.parseInt(category_id));
//            article.setArticleCategory(articleCategory);
//        }
//        List<Article> articles = sysArticleMapper.selectArticleList(article);
//        return articles;
//    }

}
