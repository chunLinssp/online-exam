package com.jomn.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ArticleComment {

    private Integer id;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer articleId;
    /**
     * 作者ID
     */
    private Long userId;
    private Integer parentId;
    /**
     * 回复用户ID
     */
    private Long toUid;
    /**
     * 类型 0 文章的评论 1 评论的评论 2 评论的回复
     */
    private String level;


    @Override
    public String toString() {
        return "ArticleComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", parentId=" + parentId +
                ", toUid=" + toUid +
                ", level='" + level + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Long getToUid() {
        return toUid;
    }

    public void setToUid(Long toUid) {
        this.toUid = toUid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
