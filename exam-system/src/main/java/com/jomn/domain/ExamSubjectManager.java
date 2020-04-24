package com.jomn.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jomn.constant.SystemConstant;

import java.util.Date;
import java.util.List;

public class ExamSubjectManager {

    private Integer id;
    private String description;
    /**
     * 主题
     */
    private String source;
    private Integer paperId;
    /**
     * 题目类型 1.选择题 2.填空题 3.判断题questionType
     */
    private Integer questionType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 考试时间 单位分钟
     */
    private Integer totalTime;
    private Integer grade;
    private String term;
    private String major;
    private String institute;
    /**
     * 考试分数
     */
    private Integer totalSource;
    private String type;
    private String tips;
    /**
     * 难度等级
     */
    private Integer level;
    /**
     * 题目集合
     */
    private List<ExamFullQues> examFullQues;
    private List<ExamJudgeQues> examJudgeQues;
    private List<ExamMultiQues> examMultiQues;


    @Override
    public String toString() {
        return "ExamSubjectManager{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", source='" + source + '\'' +
                ", paperId=" + paperId +
                ", questionType=" + questionType +
                ", createTime=" + createTime +
                ", totalTime=" + totalTime +
                ", grade=" + grade +
                ", term='" + term + '\'' +
                ", major='" + major + '\'' +
                ", institute='" + institute + '\'' +
                ", totalSource=" + totalSource +
                ", type='" + type + '\'' +
                ", tips='" + tips + '\'' +
                ", level='" + level + '\'' +
                ", examFullQues=" + examFullQues +
                ", examJudgeQues=" + examJudgeQues +
                ", examMultiQues=" + examMultiQues +
                '}';
    }

    public Integer getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public List<ExamFullQues> getExamFullQues() {
        return examFullQues;
    }

    public void setExamFullQues(List<ExamFullQues> examFullQues) {
        this.examFullQues = examFullQues;
    }

    public List<ExamJudgeQues> getExamJudgeQues() {
        return examJudgeQues;
    }

    public void setExamJudgeQues(List<ExamJudgeQues> examJudgeQues) {
        this.examJudgeQues = examJudgeQues;
    }

    public List<ExamMultiQues> getExamMultiQues() {
        return examMultiQues;
    }

    public void setExamMultiQues(List<ExamMultiQues> examMultiQues) {
        this.examMultiQues = examMultiQues;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Integer getTotalSource() {
        return totalSource;
    }

    public void setTotalSource(Integer totalSource) {
        this.totalSource = totalSource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
