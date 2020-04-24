package com.jomn.domain;

import java.util.List;

public class ArticleCategory {

    private Integer id;
    private String avatar;
    private String categoryname;
    private String description;
    /**
     * 多标签 需要修改
     */
    private List<ArticleTag> articleTag;


    @Override
    public String toString() {
        return "ArticleCategory{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", description='" + description + '\'' +
                ", articleTag=" + articleTag +
                '}';
    }


    public List<ArticleTag> getArticleTag() {
        return articleTag;
    }

    public void setArticleTag(List<ArticleTag> articleTag) {
        this.articleTag = articleTag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
