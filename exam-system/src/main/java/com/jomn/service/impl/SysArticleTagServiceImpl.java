package com.jomn.service.impl;

import com.jomn.domain.ArticleTag;
import com.jomn.mapper.SysArticleTagMapper;
import com.jomn.service.SysArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysArticleTagServiceImpl implements SysArticleTagService {

    @Autowired
    SysArticleTagMapper sysArticleTagMapper;

    /**
     * 修改文标签
     */
   @Override
   public void updateTagById(ArticleTag articleTag) {
       sysArticleTagMapper.updateTagById(articleTag);
   }

    /**
     * 增加文章标签
     */
    @Override
    public void insertTag(ArticleTag articleTag) {
        sysArticleTagMapper.insertTag(articleTag);
    }

    /**
     * 查询所有标签
     */
    @Override
    public List<ArticleTag> selectTagList(ArticleTag articleTag) {
        List<ArticleTag> articleTags = sysArticleTagMapper.selectTagList(articleTag);
        return articleTags;
    }

    @Override
    public void insertAricleTagTmp(Integer id ,String[] tags) {
        sysArticleTagMapper.insertAricleTagTmp(id,tags);
    }


}
