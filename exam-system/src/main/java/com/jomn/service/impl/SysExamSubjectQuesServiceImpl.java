package com.jomn.service.impl;

import com.jomn.constant.SystemConstant;
import com.jomn.domain.*;
import com.jomn.mapper.SysExamFullQuesMapper;
import com.jomn.mapper.SysExamJudgeQuesMapper;
import com.jomn.mapper.SysExamMultiQuesMapper;
import com.jomn.mapper.SysExamSubjectQuesMapper;
import com.jomn.service.SysExamSubjectQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  试卷主题管理,
 */
@Service
public class SysExamSubjectQuesServiceImpl implements SysExamSubjectQuesService {

    @Autowired
    SysExamSubjectQuesMapper sysExamSubjectQuesMapper;
    @Autowired
    SysExamMultiQuesMapper sysExamMultiQuesMapper;
    @Autowired
    SysExamJudgeQuesMapper sysExamJudgeQuesMapper;
    @Autowired
    SysExamFullQuesMapper sysExamFullQuesMapper;


    @Override
    public List<ExamSubjectManager> selectSubjectList(ExamSubjectManager examSubjectManager) {
        Integer questionType = examSubjectManager.getQuestionType();
        if(questionType == SystemConstant.ALL_EXAM_CATEGORY) {
            examSubjectManager.setQuestionType(null);
        }
        return sysExamSubjectQuesMapper.selectSubjectList(examSubjectManager);
    }

    @Override
    public ExamQuestionStore selectQuestionList(ExamSubjectManager examSubjectManager) {
        List<ExamQuestionTemp> examQuestionTemps = sysExamSubjectQuesMapper.selectExamQuestionTempList(examSubjectManager);
        ExamQuestionStore examQuestionStore = new ExamQuestionStore();
        List<Integer> FullQuesIds = new ArrayList<>();
        List<Integer> JudgeQuesIds = new ArrayList<>();
        List<Integer> MultiQuesIds = new ArrayList<>();
        for (ExamQuestionTemp examQuestionTemp : examQuestionTemps) {
            Integer type = examQuestionTemp.getQuestionType();
            Integer questionId = examQuestionTemp.getQuestionId();
            switch (type){
                case SystemConstant.FULL_EXAM_CATEGORY :{
                    FullQuesIds.add(questionId);
                    break;
                }
                case SystemConstant.JUDGE_EXAM_CATEGORY :{
                    JudgeQuesIds.add(questionId);
                    break;
                }
                case SystemConstant.MULTI_EXAM_CATEGORY:{
                    MultiQuesIds.add(questionId);
                    break;
                }
            }
        }
        examQuestionStore.setFullQues(sysExamFullQuesMapper.selectFullQuesListByIds(FullQuesIds));;
        examQuestionStore.setJudgeQues(sysExamJudgeQuesMapper.selectJudgeQuesListByIds(JudgeQuesIds));;
        examQuestionStore.setMultiQues(sysExamMultiQuesMapper.selectMultiQuesListByIds(MultiQuesIds));;
        return examQuestionStore;
    }






    @Override
    public List<ExamFullQues> selectFullQuesByType(Integer type) {
        ExamSubjectManager examSubjectManager = new ExamSubjectManager();
        examSubjectManager.setQuestionType(SystemConstant.FULL_EXAM_CATEGORY);
        List<ExamQuestionTemp> examQuestionTemps = sysExamSubjectQuesMapper.selectExamQuestionTempList(examSubjectManager);
        List<Integer> Ids = loadQuestionIds(examQuestionTemps);
        List<ExamFullQues> examFullQues = sysExamFullQuesMapper.selectFullQuesListByIds(Ids);
        return examFullQues;
    }

    @Override
    public List<ExamJudgeQues> selectJudgeQuesByType(Integer type) {
        ExamSubjectManager examSubjectManager = new ExamSubjectManager();
        examSubjectManager.setQuestionType(SystemConstant.JUDGE_EXAM_CATEGORY);
        List<ExamQuestionTemp> examQuestionTemps = sysExamSubjectQuesMapper.selectExamQuestionTempList(examSubjectManager);
        List<Integer> Ids = loadQuestionIds(examQuestionTemps);
        List<ExamJudgeQues> examJudgeQues = sysExamJudgeQuesMapper.selectJudgeQuesListByIds(Ids);
        return examJudgeQues;
    }

    @Override
    public List<ExamMultiQues> selectMultiQuesByType(Integer type) {
        ExamSubjectManager examSubjectManager = new ExamSubjectManager();
        examSubjectManager.setQuestionType(SystemConstant.MULTI_EXAM_CATEGORY);
        List<ExamQuestionTemp> examQuestionTemps = sysExamSubjectQuesMapper.selectExamQuestionTempList(examSubjectManager);
        List<Integer> Ids = loadQuestionIds(examQuestionTemps);
        List<ExamMultiQues> examMultiQues = sysExamMultiQuesMapper.selectMultiQuesListByIds(Ids);
        return examMultiQues;
    }

    public List<Integer> loadQuestionIds(List<ExamQuestionTemp> examQuestionTemps) {
        List<Integer> ids = new ArrayList<>();
        for (ExamQuestionTemp examQuestionTemp : examQuestionTemps) {
            examQuestionTemp.getQuestionId();
            ids.add(examQuestionTemp.getQuestionId());
        }
        return ids;
    }


}
