package com.jomn.mapper;

import com.jomn.domain.ExamJudgeQues;

import java.util.List;

/**
 * 判断题
 */
public interface SysExamJudgeQuesMapper {

    /**
     * 修改信息
     */
    public void updateJudgeQuesById(ExamJudgeQues examJudgeQues);

    /**
     * 增加信息
     */
    public void insertJudgeQues(ExamJudgeQues ques);

    /**
     * 查询信息
     */
    public List<ExamJudgeQues> selectJudgeQuesList();
    /**
     * 通过Id查询
     */
    public List<ExamJudgeQues> selectJudgeQuesListByIds(List<Integer> dis);




}
