package com.osd.prefect.system.data.dao.student;

import com.osd.prefect.system.model.student.Student;

import java.util.List;

public interface StudentDao {
    Student getStudentByID(String studentID);
    List<Student> getAllStudentsInDepartment(String departmentID);
}
