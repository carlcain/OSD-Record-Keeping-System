package com.osd.prefect.system.model.disciplinary_action;

public class DisciplinaryAction {
    public DisciplinaryAction(String actionID, String action, String description) {
        this.actionID = actionID;
        this.action = action;
        this.description = description;
    }

    private String actionID;
    private String action;
    private String description;

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
