/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblquiz;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author visug
 */
public class TblQuizDTO implements Serializable{
    private String id;
    private String question;
    private String answerContentID;
    private String answerCorrect;
    private Date createDate;
    private String subject;
    private boolean status;

    public TblQuizDTO() {
    }

    public TblQuizDTO(String question, String answerContentID) {
        this.question = question;
        this.answerContentID = answerContentID;
    }

    public TblQuizDTO(String question, String answerContentID, String answerCorrect) {
        this.question = question;
        this.answerContentID = answerContentID;
        this.answerCorrect = answerCorrect;
    }

    public TblQuizDTO(String id, String question, String answerContentID, String answerCorrect, Date createDate, String subject, boolean status) {
        this.id = id;
        this.question = question;
        this.answerContentID = answerContentID;
        this.answerCorrect = answerCorrect;
        this.createDate = createDate;
        this.subject = subject;
        this.status = status;
    }

    public TblQuizDTO(String id, String question, String answerContentID, String answerCorrect, String subject) {
        this.id = id;
        this.question = question;
        this.answerContentID = answerContentID;
        this.answerCorrect = answerCorrect;
        this.subject = subject;
    }
    

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the answerContentID
     */
    public String getAnswerContentID() {
        return answerContentID;
    }

    /**
     * @param answerContentID the answerContentID to set
     */
    public void setAnswerContentID(String answerContentID) {
        this.answerContentID = answerContentID;
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
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
