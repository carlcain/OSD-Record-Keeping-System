package com.osd.prefect.system.app.facade.violation;

import com.osd.prefect.system.model.violation.Violation;

import java.util.Date;
import java.util.List;

public interface ViolationFacade {
    List<Violation> getAllViolations();
    boolean addViolation(String studentId, String prefectID, String offenseID, String actionID, String remarks);
    void editViolation(Violation violation);
    List<Violation> getAllViolationsPerStudent(String StudentID);
}
