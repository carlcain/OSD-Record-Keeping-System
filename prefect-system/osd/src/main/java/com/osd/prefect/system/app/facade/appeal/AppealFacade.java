package com.osd.prefect.system.app.facade.appeal;

import com.osd.prefect.system.model.appeal.Appeal;

import java.util.List;

public interface AppealFacade {
    void addAppeal(String violationID, String studentID, String message);
    void updateAppealStatus(String appealID, String status);

    List<Appeal> getAllAppeals();
}
