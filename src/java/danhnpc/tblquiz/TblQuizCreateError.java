/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblquiz;

import java.io.Serializable;

/**
 *
 * @author visug
 */
public class TblQuizCreateError implements Serializable{
    private String idLengthErr;
    private String idNumberErr;
    private String nameLengthErr;
    private String answerALengthErr;
    private String answerBLengthErr;
    private String answerCLengthErr;
    private String answerDLengthErr;
    private String answerCorrectLengthErr;
    private String idDuplicateErr;

    public TblQuizCreateError() {
    }

    public TblQuizCreateError(String idLengthErr, String idNumberErr, String nameLengthErr, String answerALengthErr, String answerBLengthErr, String answerCLengthErr, String answerDLengthErr, String answerCorrectLengthErr, String idDuplicateErr) {
        this.idLengthErr = idLengthErr;
        this.idNumberErr = idNumberErr;
        this.nameLengthErr = nameLengthErr;
        this.answerALengthErr = answerALengthErr;
        this.answerBLengthErr = answerBLengthErr;
        this.answerCLengthErr = answerCLengthErr;
        this.answerDLengthErr = answerDLengthErr;
        this.answerCorrectLengthErr = answerCorrectLengthErr;
        this.idDuplicateErr = idDuplicateErr;
    }

    /**
     * @return the idLengthErr
     */
    public String getIdLengthErr() {
        return idLengthErr;
    }

    /**
     * @param idLengthErr the idLengthErr to set
     */
    public void setIdLengthErr(String idLengthErr) {
        this.idLengthErr = idLengthErr;
    }

    /**
     * @return the nameLengthErr
     */
    public String getNameLengthErr() {
        return nameLengthErr;
    }

    /**
     * @param nameLengthErr the nameLengthErr to set
     */
    public void setNameLengthErr(String nameLengthErr) {
        this.nameLengthErr = nameLengthErr;
    }

    /**
     * @return the answerALengthErr
     */
    public String getAnswerALengthErr() {
        return answerALengthErr;
    }

    /**
     * @param answerALengthErr the answerALengthErr to set
     */
    public void setAnswerALengthErr(String answerALengthErr) {
        this.answerALengthErr = answerALengthErr;
    }

    /**
     * @return the answerBLengthErr
     */
    public String getAnswerBLengthErr() {
        return answerBLengthErr;
    }

    /**
     * @param answerBLengthErr the answerBLengthErr to set
     */
    public void setAnswerBLengthErr(String answerBLengthErr) {
        this.answerBLengthErr = answerBLengthErr;
    }

    /**
     * @return the answerCLengthErr
     */
    public String getAnswerCLengthErr() {
        return answerCLengthErr;
    }

    /**
     * @param answerCLengthErr the answerCLengthErr to set
     */
    public void setAnswerCLengthErr(String answerCLengthErr) {
        this.answerCLengthErr = answerCLengthErr;
    }

    /**
     * @return the answerDLengthErr
     */
    public String getAnswerDLengthErr() {
        return answerDLengthErr;
    }

    /**
     * @param answerDLengthErr the answerDLengthErr to set
     */
    public void setAnswerDLengthErr(String answerDLengthErr) {
        this.answerDLengthErr = answerDLengthErr;
    }

    /**
     * @return the answerCorrectLengthErr
     */
    public String getAnswerCorrectLengthErr() {
        return answerCorrectLengthErr;
    }

    /**
     * @param answerCorrectLengthErr the answerCorrectLengthErr to set
     */
    public void setAnswerCorrectLengthErr(String answerCorrectLengthErr) {
        this.answerCorrectLengthErr = answerCorrectLengthErr;
    }

    /**
     * @return the idDuplicateErr
     */
    public String getIdDuplicateErr() {
        return idDuplicateErr;
    }

    /**
     * @param idDuplicateErr the idDuplicateErr to set
     */
    public void setIdDuplicateErr(String idDuplicateErr) {
        this.idDuplicateErr = idDuplicateErr;
    }

    /**
     * @return the idNumberErr
     */
    public String getIdNumberErr() {
        return idNumberErr;
    }

    /**
     * @param idNumberErr the idNumberErr to set
     */
    public void setIdNumberErr(String idNumberErr) {
        this.idNumberErr = idNumberErr;
    }
    
}
