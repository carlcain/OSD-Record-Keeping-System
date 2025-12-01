package com.osd.prefect.system.model.department;

public class Department {

    private String departmentID;

    public Department(String departmentID, String departmentName, String departmentheadID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentheadID = departmentheadID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    private String departmentheadID;

    public String getDepartmentheadID() {
        return departmentheadID;
    }

    public void setDepartmentheadID(String departmentheadID) {
        this.departmentheadID = departmentheadID;
    }

}
