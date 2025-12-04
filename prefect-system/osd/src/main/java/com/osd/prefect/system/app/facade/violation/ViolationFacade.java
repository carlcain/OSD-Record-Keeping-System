package com.osd.prefect.system.app.facade.violation;

import com.osd.prefect.system.model.violation.Violation;

import java.util.Date;
import java.util.List;

public interface ViolationFacade {
    List<Violation> getAllViolations();
    void addViolation(String studentId, String prefectID, String offenseID, Date dateOfViolation, String actionID, Date dateOfResolution, String remarks, String status);
    void editViolation(Violation violation);
}
