package com.osd.prefect.system.data.dao.student;

import com.osd.prefect.system.model.student.Student;

public interface StudentDao {
    Student getStudentByID(String studentID);

}
