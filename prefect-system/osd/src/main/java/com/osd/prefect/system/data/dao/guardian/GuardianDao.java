package com.osd.prefect.system.data.dao.guardian;

import com.osd.prefect.system.model.guardian.Guardian;

public interface GuardianDao {
    Guardian getGuardianByStudentID(String studentID);
}
