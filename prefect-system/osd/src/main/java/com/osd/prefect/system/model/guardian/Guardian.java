package com.osd.prefect.system.model.guardian;

public class Guardian {

    public Guardian(String guardianName, String contactNumber, String relationship, String studentID) {
        this.guardianName = guardianName;
        this.contactNumber = contactNumber;
        this.relationship = relationship;
        this.studentID = studentID;
    }

    private String guardianName;
    private String contactNumber;
    private String relationship;
    private String studentID;

    public Guardian() {

    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
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
