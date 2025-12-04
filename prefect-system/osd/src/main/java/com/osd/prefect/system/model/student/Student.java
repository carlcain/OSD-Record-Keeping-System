package com.osd.prefect.system.model.student;

public class Student {

    private String studentID;
    private String userID;
    private String personID;
    private String studentLevel;
    private String section;
    private String departmentID;

    public Student(String studentID, String userID, String personID, String studentLevel, String section, String departmentID) {
        this.studentID = studentID;
        this.userID = userID;
        this.personID = personID;
        this.studentLevel = studentLevel;
        this.section = section;
        this.departmentID = departmentID;
    }

    public Student()
    {

    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

}