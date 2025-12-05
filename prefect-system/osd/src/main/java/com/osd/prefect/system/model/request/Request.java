package com.osd.prefect.system.model.request;

public class Request
{
    private String RequestID;
    private String DepartmentHeadID;
    private String Details;
    private String Type;
    private String Message;
    private String Status;

    public String getRequestID() {
        return RequestID;
    }

    public void setRequestID(String requestID) {
        RequestID = requestID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

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
