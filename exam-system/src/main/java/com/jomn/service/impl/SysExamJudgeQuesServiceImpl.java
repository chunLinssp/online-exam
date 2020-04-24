package com.jomn.service.impl;

import com.jomn.domain.ExamJudgeQues;
import com.jomn.mapper.SysExamJudgeQuesMapper;
import com.jomn.service.SysExamJudgeQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 判断题
 */
@Service
public class SysExamJudgeQuesServiceImpl implements SysExamJudgeQuesService {

    @Autowired
    SysExamJudgeQuesMapper sysExamJudgeQuesMapper;


    /**
     * 修改信息
     */
    public void updateJudgeQuesById(ExamJudgeQues examJudgeQues) {
        sysExamJudgeQuesMapper.updateJudgeQuesById(examJudgeQues);
    }

    /**
     * 增加信息
     */
    public void insertJudgeQues(ExamJudgeQues ques) {
        sysExamJudgeQuesMapper.insertJudgeQues(ques);
    }

    /**
     * 查询信息
     */
    public List<ExamJudgeQues> selectJudgeQuesList() {
        List<ExamJudgeQues> examJudgeQues = sysExamJudgeQuesMapper.selectJudgeQuesList();
        return examJudgeQues;
    }




}
