package com.osd.prefect.system.app.facade.appeal;

import com.osd.prefect.system.model.appeal.Appeal;

public interface AppealFacade {
    Appeal addAppeal(String violationID, String studentID, String message);
    void editAppealStatus(Appeal appeal, String status);
}
