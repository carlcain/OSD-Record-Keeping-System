package com.osd.prefect.system.data.dao.violation;

import com.osd.prefect.system.model.appeal.Appeal;
import com.osd.prefect.system.model.student.Student;
import com.osd.prefect.system.model.violation.Violation;

import java.util.Date;
import java.util.List;

public interface ViolationDao {
    List<Violation> getAllViolations();
    boolean addViolation(String studentId, String prefectID, String offenseID, String actionID, String remarks);
    List<Violation> getAllViolationsPerStudent(String StudentID);

}
