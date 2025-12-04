package com.osd.prefect.system.model.users;

public class User {
    private String userID;
    private String username;
    private String userPassword;
    private String userRole;

    public User(String userID, String username, String userPassword, String userRole) {
        this.userID = userID;
        this.username = username;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public User() {
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }


}

