package com.jomn.mapper;

import com.jomn.domain.ExamFullQues;

import java.util.List;

/**
 * 填空题
 */
public interface SysExamFullQuesMapper {

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

    /**
     * 通过Id查询
     */
    public List<ExamFullQues> selectFullQuesListByIds(List<Integer> dis);



}
