package com.jomn.service;

import com.jomn.domain.Article;
import com.jomn.domain.ArticleBody;

import java.util.List;

public interface SysArticleBodyService {

    /**
     * id查询文章内容
     */
    public ArticleBody selectArticleBodyById(Long id);


    /**
     * 增加文章内容
     */
    public int insertArticleBody(ArticleBody articleBody);

}
