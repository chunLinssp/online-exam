package com.jomn.service.impl;

import com.jomn.domain.ExamMultiQues;
import com.jomn.mapper.SysExamMultiQuesMapper;
import com.jomn.service.SysExamJudgeQuesService;
import com.jomn.service.SysExamMultiQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 选择题
 */
@Service
public class SysExamMultiQuesServiceImpl implements SysExamMultiQuesService {

    @Autowired
    SysExamMultiQuesMapper sysExamMultiQuesMapper;

    /**
     * 修改信息
     */
    public void updateMultiQuesById(ExamMultiQues examMultiQues) {
        sysExamMultiQuesMapper.updateMultiQuesById(examMultiQues);
    }

    /**
     * 增加信息
     */
    public void insertMultiQues(ExamMultiQues ques) {
        sysExamMultiQuesMapper.insertMultiQues(ques);
    }

    /**
     * 查询信息
     */
    public List<ExamMultiQues> selectMultiQuesList() {
        List<ExamMultiQues> examMultiQues = sysExamMultiQuesMapper.selectMultiQuesList();
        return examMultiQues;
    }




}
