/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblquiz;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Result implements Serializable{
    private int page;
    private String answerChosen;
    private String answerCorrect;

    public Result() {
    }

    public Result(int page, String answerChosen, String answerCorrect) {
        this.page = page;
        this.answerChosen = answerChosen;
        this.answerCorrect = answerCorrect;
    }

    /**
     * @return the answerChosen
     */
    public String getAnswerChosen() {
        return answerChosen;
    }

    /**
     * @param answerChosen the answerChosen to set
     */
    public void setAnswerChosen(String answerChosen) {
        this.answerChosen = answerChosen;
    }

    /**
     * @return the answerCorrect
     */
    public String getAnswerCorrect() {
        return answerCorrect;
    }

    /**
     * @param answerCorrect the answerCorrect to set
     */
    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
    
}
