package com.jomn.service.impl;

import com.jomn.domain.ExamFullQues;
import com.jomn.mapper.SysExamFullQuesMapper;
import com.jomn.service.SysExamFullQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 填空题
 */
@Service
public class SysExamFullQuesServiceImpl implements SysExamFullQuesService {

    @Autowired
    SysExamFullQuesMapper sysExamFullQuesMapper;
    /**
     * 修改信息
     */
    public void updateFullQuesById(ExamFullQues examFullQues) {
        sysExamFullQuesMapper.updateFullQuesById(examFullQues);
    }

    /**
     * 增加信息
     */
    public void insertFullQues(ExamFullQues ques) {
        sysExamFullQuesMapper.insertFullQues(ques);
    }

    /**
     * 查询信息
     */
    public List<ExamFullQues> selectFullQuesList() {
        List<ExamFullQues> examFullQues = sysExamFullQuesMapper.selectFullQuesList();
        return examFullQues;
    }




}
