package com.jomn.mapper;

import com.jomn.domain.ArticleTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysArticleTagMapper {

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
     * tag_id查询标签
     */
    public ArticleTag selectArticleTagById(Integer id);

    /**
     * 文章id查询tag
     */
    public List<ArticleTag> selectArticleTagsByArticleId(Integer id);

    /**
     * 通过category_id查询
     */
    public List<ArticleTag> selectArticleTagsByCategoryId(Integer id);

   /**
    *  插入tag—article中间表标签
    */
    public void insertAricleTagTmp(@Param("id") Integer id ,@Param("array") String[] tags);




}
