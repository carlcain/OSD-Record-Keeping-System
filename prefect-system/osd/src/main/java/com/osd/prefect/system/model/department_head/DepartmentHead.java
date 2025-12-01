package com.osd.prefect.system.model.department_head;

public class DepartmentHead {

    public DepartmentHead(String departmentheadID, String departmentID) {
        this.departmentheadID = departmentheadID;
        this.departmentID = departmentID;

    }
    private String departmentheadID;

    public String getDepartmentheadID() {
        return departmentheadID;
    }

    public void setDepartmentheadID(String departmentheadID) {
        this.departmentheadID = departmentheadID;
    }

    private String departmentID;

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

}
