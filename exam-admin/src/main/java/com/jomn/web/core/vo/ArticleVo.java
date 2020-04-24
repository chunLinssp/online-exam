package com.jomn.web.core.vo;

import java.util.Arrays;
import java.util.Date;

public class ArticleVo {

    private String articleTitle;
    private String articleSummary;
    private Integer categoryId;
    private String[] tagId;
    private String articleBody;
    private String articleBodyHtml;

    private Date createTime;
    private Long userId;


    @Override
    public String toString() {
        return "ArticleVo{" +
                "articleTitle='" + articleTitle + '\'' +
                ", articleSummary='" + articleSummary + '\'' +
                ", categoryId=" + categoryId +
                ", tagId=" + Arrays.toString(tagId) +
                ", articleBody='" + articleBody + '\'' +
                ", articleBodyHtml='" + articleBodyHtml + '\'' +
                ", createTime=" + createTime +
                ", userId=" + userId +
                '}';
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String[] getTagId() {
        return tagId;
    }

    public void setTagId(String[] tagId) {
        this.tagId = tagId;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }

    public String getArticleBodyHtml() {
        return articleBodyHtml;
    }

    public void setArticleBodyHtml(String articleBodyHtml) {
        this.articleBodyHtml = articleBodyHtml;
    }
}
