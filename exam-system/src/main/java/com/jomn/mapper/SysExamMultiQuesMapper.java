package com.jomn.mapper;

import com.jomn.domain.ExamMultiQues;

import java.util.List;

/**
 * 选择题
 */
public interface SysExamMultiQuesMapper {

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
    /**
     * 通过Id查询
     */
    public List<ExamMultiQues> selectMultiQuesListByIds(List<Integer> dis);




}
