package com.osd.prefect.system.data.dao.appeal;

import com.osd.prefect.system.model.appeal.Appeal;

import java.util.List;

public interface AppealDao {
    boolean addAppeal(String violationID, String studentID,String message);
    void editAppealStatus(Appeal appeal, String status);
    List<Appeal> getAllAppeals();
}
