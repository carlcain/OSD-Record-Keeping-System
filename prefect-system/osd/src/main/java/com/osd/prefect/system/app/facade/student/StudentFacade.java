package com.osd.prefect.system.app.facade.student;

import com.osd.prefect.system.model.student.Student;

import java.util.List;

public interface StudentFacade {
    Student getStudentByID(String userID);
    List<Student> getStudentsByDepartmentID();
    List<Student> getStudentsBySection();
    List<Student> getStudentsByStudentLevel();

}
