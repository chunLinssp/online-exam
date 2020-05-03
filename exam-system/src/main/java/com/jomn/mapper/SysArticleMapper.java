package com.jomn.mapper;

import com.jomn.domain.Article;

import java.util.List;

public interface SysArticleMapper {

    /**
     * 审批文章
     */
    public void updateArticleStatusById(List<Article> article);

    /**
     * 批量删除文章
     */
    public void delteArticleByIds(Integer[] ids);

    /**
     * 查询文章通过useId
     */
    public List<Article> selectArticleListById(Long useId);

    /**
     * 查询所有文章
     */
    public List<Article> selectArticleList(Article Article);

    /**
     * 查询所有文章通过 categoryId,tagId
     */
    public List<Article> selectArticleAllList(Article article);

    /**
     * 增加文章
     */
    public void insertArticle(Article article);

    /**
     * 增加文章内容
     */
    public void insertArticleBody(Article article);

    /**
     * 通过用户id查询
     */
    public List<Article> selectArticleListByUid(Long id);

    /**
     * 通过Tag_id查询文章
     */
    public List<Article> selectArticleByTagId(Integer id);

}
