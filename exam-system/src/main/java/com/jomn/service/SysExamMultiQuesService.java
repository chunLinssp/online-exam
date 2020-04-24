package com.jomn.service;

import com.jomn.domain.ExamJudgeQues;
import com.jomn.domain.ExamMultiQues;

import java.util.List;

/**
 * 选择题
 */
public interface SysExamMultiQuesService {

    /**
     * 修改信息
     */
    public void updateMultiQuesById(ExamMultiQues examMultiQues);

    /**
     * 增加信息
     */
    public void insertMultiQues(ExamMultiQues ques);

    /**
     * 查询信息
     */
    public List<ExamMultiQues> selectMultiQuesList();




}
