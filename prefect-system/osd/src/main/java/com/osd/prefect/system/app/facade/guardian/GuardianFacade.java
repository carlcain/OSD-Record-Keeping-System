package com.osd.prefect.system.app.facade.guardian;

import com.osd.prefect.system.model.guardian.Guardian;

public interface GuardianFacade {
    Guardian getGuardianByStudentID(String studentID) throws Exception;
}
