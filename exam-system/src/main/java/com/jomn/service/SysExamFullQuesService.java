package com.jomn.service;

import com.jomn.domain.ExamFullQues;

import java.util.List;

/**
 * 填空题
 */
public interface SysExamFullQuesService {

    /**
     * 修改信息
     */
    public void updateFullQuesById(ExamFullQues examFullQues);

    /**
     * 增加信息
     */
    public void insertFullQues(ExamFullQues ques);

    /**
     * 查询信息
     */
    public List<ExamFullQues> selectFullQuesList();



}
