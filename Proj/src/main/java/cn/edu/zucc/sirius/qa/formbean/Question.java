package cn.edu.zucc.sirius.qa.formbean;

import java.util.Date;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:07
 */
public class Question {

    private String questionTitle;
    private String questionContent;
    private String creatorId;

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
}
