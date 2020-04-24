package com.jomn.service;

import com.jomn.domain.*;

import java.util.List;

/**
 *  试卷主题管理
 */
public interface SysExamSubjectQuesService {

    /**
     * 查询主题题目
     */
    public List<ExamSubjectManager> selectSubjectList(ExamSubjectManager examSubjectManager);

    /**
     * 查询试题卷 具体查询试题卷的内容（封装所有题型的）
     */
    public ExamQuestionStore selectQuestionList(ExamSubjectManager examSubjectManager);

    /**
     * 类型查询试卷
     */
    public List<ExamFullQues> selectFullQuesByType(Integer type);

    public List<ExamJudgeQues> selectJudgeQuesByType(Integer type);

    public List<ExamMultiQues> selectMultiQuesByType(Integer type);





}
