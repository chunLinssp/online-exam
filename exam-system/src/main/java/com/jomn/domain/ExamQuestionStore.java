package com.jomn.domain;

import java.util.Arrays;
import java.util.List;

/**
 * 存储试题卷id
 */
public class ExamQuestionStore {

    private List<ExamFullQues> FullQues;
    private List<ExamMultiQues> MultiQues;
    private List<ExamJudgeQues> JudgeQues;

    @Override
    public String toString() {
        return "ExamQuestionStore{" +
                "FullQues=" + FullQues +
                ", JudgeQues=" + JudgeQues +
                ", MultiQues=" + MultiQues +
                '}';
    }

    public List<ExamFullQues> getFullQues() {
        return FullQues;
    }

    public void setFullQues(List<ExamFullQues> fullQues) {
        FullQues = fullQues;
    }

    public List<ExamMultiQues> getMultiQues() {
        return MultiQues;
    }

    public void setMultiQues(List<ExamMultiQues> multiQues) {
        MultiQues = multiQues;
    }

    public List<ExamJudgeQues> getJudgeQues() {
        return JudgeQues;
    }

    public void setJudgeQues(List<ExamJudgeQues> judgeQues) {
        JudgeQues = judgeQues;
    }
}
