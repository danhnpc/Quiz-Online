/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblanswercontent;

import java.io.Serializable;

/**
 *
 * @author visug
 */
public class TblAnswerContentDTO implements Serializable{
    private String answerContentID;
    private String a;
    private String b;
    private String c;
    private String d;

    public TblAnswerContentDTO() {
    }

    public TblAnswerContentDTO(String answerContentID, String a, String b, String c, String d) {
        this.answerContentID = answerContentID;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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
     * @return the a
     */
    public String getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public String getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public String getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(String c) {
        this.c = c;
    }

    /**
     * @return the d
     */
    public String getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(String d) {
        this.d = d;
    }

    
}