package com.osd.prefect.system.model.student;

import com.osd.prefect.system.model.users.User;

public class Student {

    public Student(String studentID, String surname, String firstName, String middleName, String studentLevel, String section, String departmentID) {
        this.studentID = studentID;
        this.surname = surname;
        this.firstName = firstName;
        this.middleName = middleName;
        this.studentLevel = studentLevel;
        this.section = section;
        this.departmentID = departmentID;
    }

    public Student() {}

    private String studentID;
    private User user;
    private String studentLevel;
    private String section;
    private String departmentID;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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
