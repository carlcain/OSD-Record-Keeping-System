package com.osd.prefect.system.model.guardian;

public class Guardian {

    private String guardianID;
    private String personID;
    private String contactNumber;
    private String relationship;
    private String studentID;

    public Guardian(String guardianID, String personID, String contactNumber, String relationship, String studentID) {
        this.guardianID = guardianID;
        this.personID = personID;
        this.contactNumber = contactNumber;
        this.relationship = relationship;
        this.studentID = studentID;
    }

    public Guardian(){}

    public String getGuardianID() {
        return guardianID;
    }

    public void setGuardianID(String guardianID) {
        this.guardianID = guardianID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}