package com.osd.prefect.system.model.person;

public class Person {
    private String personId;
    private String lastName;
    private String firstName;
    private String middleName;


    public Person(){

    }
    public Person(String personId, String lastName, String firstName, String middleName) {
        this.personId = personId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

}
