package com.osd.prefect.system.model.request;

public class Request
{
    private String DepartmentHeadID;
    private String Details;
    private String Message;


    public Request(String departmentHeadID, String details, String message) {
        DepartmentHeadID = departmentHeadID;
        Details = details;
        Message = message;
    }

    public Request() {}

    public String getDetails() {
        return Details;
    }

    public String getDepartmentHeadID() {
        return DepartmentHeadID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public void setDepartmentHeadID(String departmentHeadID) {
        DepartmentHeadID = departmentHeadID;
    }


}
