package com.osd.prefect.system.model.prefect;

public class Prefect {

    public Prefect(String prefectID, String departmentID) {
        this.prefectID = prefectID;
        this.departmentID = departmentID;
    }

    private String prefectID;
    private String departmentID;

    public String getPrefectID() {
        return prefectID;
    }

    public void setPrefectID(String prefectID) {
        this.prefectID = prefectID;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
}
