package com.jomn.service.impl;

import com.jomn.domain.ArticleBody;
import com.jomn.mapper.SysArticleBodyMapper;
import com.jomn.service.SysArticleBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysArticleBodyServiceImpl implements SysArticleBodyService {

    @Autowired
    SysArticleBodyMapper sysArticleBodyMapper;

    /**
     * id查询文章内容
     */
    @Override
    public ArticleBody selectArticleBodyById(Long id) {
        ArticleBody articleBody = sysArticleBodyMapper.selectArticleBodyById(id);
        return articleBody;
    }


    /**
     * 增加文章内容
     */
    @Override
    public int insertArticleBody(ArticleBody articleBody) {
        return sysArticleBodyMapper.insertArticleBody(articleBody);
    }

}
