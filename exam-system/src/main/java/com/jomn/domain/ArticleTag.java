package com.jomn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jomn.core.domain.BaseEntity;

import java.util.Date;
import java.util.Map;

public class ArticleTag extends BaseEntity {

    private Integer id;
    private String avatar;
    private String tagName;
    private Long userId;
    private Integer numClick;


    @Override
    public String toString() {
        return "ArticleTag{" +
                "id=" + id +
                ", avatar='" + avatar + '\'' +
                ", tagName='" + tagName + '\'' +
                ", userId=" + userId +
                ", numClick=" + numClick +
                '}';
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getNumClick() {
        return numClick;
    }

    public void setNumClick(Integer numClick) {
        this.numClick = numClick;
    }
}
