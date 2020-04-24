package com.jomn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Article {

    private Integer id;
    private Integer commentCounts;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private String summary;
    private String title;
    private Integer viewCounts;
    private Integer weight;

    private SysUser sysUser;
    private ArticleBody articleBody;
    private ArticleCategory articleCategory;
    private Map<String,Object> params;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", commentCounts=" + commentCounts +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", viewCounts=" + viewCounts +
                ", weight=" + weight +
                ", sysUser=" + sysUser +
                ", articleBody=" + articleBody +
                ", articleCategory=" + articleCategory +
                '}';
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public ArticleBody getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(ArticleBody articleBody) {
        this.articleBody = articleBody;
    }

    public ArticleCategory getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(ArticleCategory articleCategory) {
        this.articleCategory = articleCategory;
    }
}
