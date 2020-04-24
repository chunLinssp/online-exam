package com.jomn.web.core.vo;

public class ArticleTableVo {

    /**
     * 文章Id
     */
    private Integer id;
    private String summary;
    private String status;
    private String title;
    private Integer bodyId;
    private String categoryName;

    @Override
    public String toString() {
        return "ArticleTableVo{" +
                "id=" + id +
                ", summary='" + summary + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", bodyId='" + bodyId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
