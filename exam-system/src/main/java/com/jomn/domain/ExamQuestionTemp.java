package com.jomn.domain;

public class ExamQuestionTemp {

    private Integer paperId;
    private Integer questionType;
    private Integer questionId;

    @Override
    public String toString() {
        return "ExamQuestionTemp{" +
                "paperId=" + paperId +
                ", questionType=" + questionType +
                ", questionId=" + questionId +
                '}';
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
