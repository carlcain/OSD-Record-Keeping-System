package com.osd.prefect.system.data.dao.student;

import com.osd.prefect.system.model.student.Student;
import java.util.List;

public interface StudentDao
{
   Student getStudentByID(String StudentID);
   List<Student> getStudentsByDepartmentID(String DepartmentID);
   List<Student> getStudentsBySection(String section);
   List<Student> getStudentsByStudentLevel(String studentLevel);
}
