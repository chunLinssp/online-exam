package com.jomn.mapper;

import com.jomn.domain.ArticleBody;

public interface SysArticleBodyMapper {

    /**
     * id查询文章内容
     */
    public ArticleBody selectArticleBodyById(Long id);

    /**
     * 修改文章内容
     */
    public void updateArticleBody(ArticleBody articleBody);

    /**
     * 增加文章内容
     */
    public int insertArticleBody(ArticleBody articleBody);

    /**
     * 删除文章内容
     */
    public void deleteArticleBodyById(Integer id);

}
