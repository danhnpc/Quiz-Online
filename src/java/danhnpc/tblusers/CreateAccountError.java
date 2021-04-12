/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhnpc.tblusers;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class CreateAccountError implements Serializable{
    private String userIdLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String confirmPasswordErr;
    private String duplicateUserIdErr;

    public CreateAccountError() {
    }

    public CreateAccountError(String userIdLengthErr, String passwordLengthErr, String fullNameLengthErr, String confirmPasswordErr, String duplicateUserIdErr) {
        this.userIdLengthErr = userIdLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.fullNameLengthErr = fullNameLengthErr;
        this.confirmPasswordErr = confirmPasswordErr;
        this.duplicateUserIdErr = duplicateUserIdErr;
    }

    /**
     * @return the userIdLengthErr
     */
    public String getUserIdLengthErr() {
        return userIdLengthErr;
    }

    /**
     * @param userIdLengthErr the userIdLengthErr to set
     */
    public void setUserIdLengthErr(String userIdLengthErr) {
        this.userIdLengthErr = userIdLengthErr;
    }

    /**
     * @return the passwordLengthErr
     */
    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    /**
     * @param passwordLengthErr the passwordLengthErr to set
     */
    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    /**
     * @return the fullNameLengthErr
     */
    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    /**
     * @param fullNameLengthErr the fullNameLengthErr to set
     */
    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    /**
     * @return the confirmPasswordErr
     */
    public String getConfirmPasswordErr() {
        return confirmPasswordErr;
    }

    /**
     * @param confirmPasswordErr the confirmPasswordErr to set
     */
    public void setConfirmPasswordErr(String confirmPasswordErr) {
        this.confirmPasswordErr = confirmPasswordErr;
    }

    /**
     * @return the duplicateUserIdErr
     */
    public String getDuplicateUserIdErr() {
        return duplicateUserIdErr;
    }

    /**
     * @param duplicateUserIdErr the duplicateUserIdErr to set
     */
    public void setDuplicateUserIdErr(String duplicateUserIdErr) {
        this.duplicateUserIdErr = duplicateUserIdErr;
    }
    
}
