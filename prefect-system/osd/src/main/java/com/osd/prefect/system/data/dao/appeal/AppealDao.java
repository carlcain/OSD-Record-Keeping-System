package com.osd.prefect.system.data.dao.appeal;

import com.osd.prefect.system.model.appeal.Appeal;

public interface AppealDao {
    Appeal addAppeal(String violationID, String studentID,String message);
    void editAppealStatus(Appeal appeal, String status);
}
