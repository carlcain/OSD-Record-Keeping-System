package com.osd.prefect.system.model.users;

public class User {

    public User(String userID, String username, String userPassword, String userRole) {
        this.userID = userID;
        this.username = username;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User() {
    }

    private String userID;
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}

