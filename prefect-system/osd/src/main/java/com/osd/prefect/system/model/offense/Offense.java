package com.osd.prefect.system.model.offense;

public class Offense {

    public Offense(String offenseID, String offense, String type, String remarks) {
        this.offenseID = offenseID;
        this.offense = offense;
        this.type = type;
        this.remarks = remarks;
    }

    private String offenseID;
    private String offense;
    private String type;
    private String remarks;

    public Offense() {

    }

    public String getOffenseID() {
        return offenseID;
    }

    public void setOffenseID(String offenseID) {
        this.offenseID = offenseID;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
