package com.osd.prefect.system.model.violation;

import java.util.Date;

public class Violation {

    public Violation(String violationID, String studentID, String prefectID, String offenseID, Date dateofViolation, String actionID, Date dateofResolution, String remarks, String status) {
        this.violationID = violationID;
        this.studentID = studentID;
        this.prefectID = prefectID;
        this.offenseID = offenseID;
        DateofViolation = dateofViolation;
        this.actionID = actionID;
        DateofResolution = dateofResolution;
        this.remarks = remarks;
        this.status = status;
    }

    private String violationID;
    private String studentID;
    private String prefectID;
    private String offenseID;
    private Date DateofViolation;
    private String actionID;
    private Date DateofResolution;
    private String remarks;
    private String status;

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

    public String getPrefectID() {
        return prefectID;
    }

    public void setPrefectID(String prefectID) {
        this.prefectID = prefectID;
    }

    public String getOffenseID() {
        return offenseID;
    }

    public void setOffenseID(String offenseID) {
        this.offenseID = offenseID;
    }

    public Date getDateofViolation() {
        return DateofViolation;
    }

    public void setDateofViolation(Date dateofViolation) {
        DateofViolation = dateofViolation;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public Date getDateofResolution() {
        return DateofResolution;
    }

    public void setDateofResolution(Date dateofResolution) {
        DateofResolution = dateofResolution;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
