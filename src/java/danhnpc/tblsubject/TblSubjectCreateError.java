/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblsubject;

import java.io.Serializable;

/**
 *
 * @author visug
 */
public class TblSubjectCreateError implements Serializable{
    private String idLengthErr;
    private String nameLengthErr;
    private String idDuplicateErr;

    public TblSubjectCreateError() {
    }

    public TblSubjectCreateError(String idLengthErr, String nameLengthErr, String idDuplicateErr) {
        this.idLengthErr = idLengthErr;
        this.nameLengthErr = nameLengthErr;
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
    
}
