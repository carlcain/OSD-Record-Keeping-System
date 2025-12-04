package com.osd.prefect.system.model.request;

public class Request
{
    private String Details;
    private String Message;

    public String getDepartmentHeadID() {
        return DepartmentHeadID;
    }

    public String getDetails() {
        return Details;
    }

    public String getMessage() {
        return Message;
    }

    private String DepartmentHeadID;

    public void setDetails(String details) {
        Details = details;
    }

    public void setDepartmentHeadID(String departmentHeadID) {
        DepartmentHeadID = departmentHeadID;
    }
}
