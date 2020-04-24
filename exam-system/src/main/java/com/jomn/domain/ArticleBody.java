package com.jomn.domain;

public class ArticleBody {

    private Integer id;
    private String content;
    private String contentHtml;


    @Override
    public String toString() {
        return "ArticleBody{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", contentHtml='" + contentHtml + '\'' +
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

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}
