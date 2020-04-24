package com.jomn.web.controller;

import com.jomn.constant.api.Result;
import com.jomn.constant.api.ResultHandle;
import com.jomn.core.page.PageDomain;
import com.jomn.domain.*;
import com.jomn.service.SysExamSubjectQuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysExamController extends BaseController{

    @Autowired
    SysExamSubjectQuesService sysExamSubjectQuesService;

    /** 所有题型 **/
    @GetMapping("/system/examView")
    @ResponseBody
    public Result examView(PageDomain pageDomain, ExamSubjectManager examSubjectManager) {
        startPage(pageDomain);
        List<ExamSubjectManager> examSubjectManagers = sysExamSubjectQuesService.selectSubjectList(examSubjectManager);
        Result success = ResultHandle.success(examSubjectManagers);
        return success;
    }



    /** 试题卷 **/
    @GetMapping("/system/detailedExam")
    @ResponseBody
    public Result startExam(ExamSubjectManager examSubjectManager) {
        Result result = loadExam(examSubjectManager);
        return result;
    }




//    /** 通过类型查询试卷 **/
//    @GetMapping("/system/typeDetailedExam")
//    @ResponseBody
//    public Result startExam(String type) {
//        Result result = executeTypeExam(type);
//        return result;
//    }

    public Result executeTypeExam(Integer type) {
        final int ALL_EXAM_CATEGORY = 0;
        final int JUDGE_EXAM_CATEGORY = 3;
        final int FULL_EXAM_CATEGORY = 2;
        final int MULTI_EXAM_CATEGORY = 1;
        int category = type;
        switch (category) {
            case MULTI_EXAM_CATEGORY:{
                List<ExamMultiQues> examMultiQues = sysExamSubjectQuesService.selectMultiQuesByType(MULTI_EXAM_CATEGORY);
                Result success = ResultHandle.success(examMultiQues);
                return success;
            }
            case JUDGE_EXAM_CATEGORY:{
                List<ExamJudgeQues> examJudgeQues = sysExamSubjectQuesService.selectJudgeQuesByType(JUDGE_EXAM_CATEGORY);
                Result success = ResultHandle.success(examJudgeQues);
                return success;
            }
            case FULL_EXAM_CATEGORY:{
                List<ExamFullQues> examFullQues = sysExamSubjectQuesService.selectFullQuesByType(FULL_EXAM_CATEGORY);
                Result success = ResultHandle.success(examFullQues);
                return success;
            }
        }
        return null;
    }

    /**
     * 加载试题卷
     */
    public Result loadExam(ExamSubjectManager examSubjectManager) {
        final int ALL_EXAM_CATEGORY = 0;
        Integer questionType = examSubjectManager.getQuestionType();
        if(questionType == ALL_EXAM_CATEGORY) {
            ExamQuestionStore examQuestionStore = sysExamSubjectQuesService.selectQuestionList(examSubjectManager);
            return ResultHandle.success(examQuestionStore);
        }else {
            return executeTypeExam(questionType);
        }
    }
}
