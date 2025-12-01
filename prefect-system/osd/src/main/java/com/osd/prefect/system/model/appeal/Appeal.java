package com.osd.prefect.system.model.appeal;

import java.util.Date;

public class Appeal {

    public Appeal(String appealID, String violationID, String studentID, String message, Date dateFiled, String status) {
        this.appealID = appealID;
        this.violationID = violationID;
        this.studentID = studentID;
        this.message = message;
        this.dateFiled = dateFiled;
        this.status = status;
    }

    private String appealID;
    private String violationID;
    private String studentID;
    private String message;
    private Date dateFiled;
    private String status;

    public String getAppealID() {
        return appealID;
    }

    public void setAppealID(String appealID) {
        this.appealID = appealID;
    }

    public String getViolationID() {
        return violationID;
    }

    public void setViolationID(String violationID) {
        this.violationID = violationID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateFiled() {
        return dateFiled;
    }

    public void setDateFiled(Date dateFiled) {
        this.dateFiled = dateFiled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
