package com.osd.prefect.system.model.prefect;

public class Prefect {

    private String prefectID;
    private String userID;
    private String personID;
    private String departmentID;

    public Prefect(String prefectID, String userID, String personID, String departmentID) {
        this.prefectID = prefectID;
        this.userID = userID;
        this.personID = personID;
        this.departmentID = departmentID;
    }

    public Prefect(){ }

    public String getPrefectID() {
        return prefectID;
    }

    public void setPrefectID(String prefectID) {
        this.prefectID = prefectID;
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