package com.jomn.service;

import com.jomn.domain.Article;
import com.jomn.domain.ArticleTag;

import java.util.List;

public interface SysArticleTagService {

    /**
     * 修改文标签
     */
   public void updateTagById(ArticleTag articleTag);

    /**
     * 增加文章标签
     */
    public void insertTag(ArticleTag articleTag);

    /**
     * 查询所有标签
     */
    public List<ArticleTag> selectTagList(ArticleTag articleTag);

    /**
     *  插入tag—article中间表标签
     */
    public void insertAricleTagTmp(Integer id ,String[] tags);







}
