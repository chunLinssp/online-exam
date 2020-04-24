package com.jomn.mapper;

import com.jomn.domain.ExamQuestionTemp;
import com.jomn.domain.ExamSubjectManager;

import java.util.List;

/**
 *  试卷主题管理
 */
public interface SysExamSubjectQuesMapper {

    /**
     * 查询主题题目
     */
    public List<ExamSubjectManager> selectSubjectList(ExamSubjectManager examSubjectManager);

    /**
     * 查询试卷数组Id
     */
    public List<ExamQuestionTemp> selectExamQuestionTempList(ExamSubjectManager examSubjectManager);

}
