package com.osd.prefect.system.model.department_head;

public class DepartmentHead {

    private String departmentHeadID;
    private String userID;
    private String personID;
    private String departmentID;

    public DepartmentHead(String departmentHeadID, String userID, String personID, String departmentID) {
        this.departmentHeadID = departmentHeadID;
        this.userID = userID;
        this.personID = personID;
        this.departmentID = departmentID;
    }

    public DepartmentHead()
    {

    }

    public String getDepartmentHeadID() {
        return departmentHeadID;
    }

    public void setDepartmentHeadID(String departmentHeadID) {
        this.departmentHeadID = departmentHeadID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

}