package com.osd.prefect.system.data.dao.appeal;

import com.osd.prefect.system.model.appeal.Appeal;

import java.util.List;

public interface AppealDao {
    boolean addAppeal(String violationID, String studentID,String message);
    boolean updateAppealStatus(String appealID, String status);
    List<Appeal> getAllAppeals();
}
