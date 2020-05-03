package com.jomn.service;

import com.jomn.domain.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface SysArticleService {

    /**
     * 审批文章
     */
    public void updateArticleStatusById(List<Article> article);

    /**
     * 批量删除文章
     */
    public void delteArticleByIds(Integer[] ids );

    /**
     * 查询文章
     */
    public List<Article> selectArticleListById(Long useId);

    /**
     * 查询所有文章
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 插入文章
     */
    public Article insertArticle(String header,Article article);

    /**
     * 通过用户id查询
     */
    public List<Article> selectArticleListByUid(Long id);

    /**
     * 查询所有文章通过 categoryId,tagId
     */
//    public List<Article> selectArticleAllList(Map<String,Object> params);

    /**
     * 通过Tag_id查询文章
     */
    public List<Article> selectArticleByTagId(Integer id);

    /**
     * 保存文章内容图片
     */
    public String saveArticlePicture(MultipartFile file);

    /**
     * 保存文章内容
     */
    public void saveArticleContent(String header , Article article);


}
