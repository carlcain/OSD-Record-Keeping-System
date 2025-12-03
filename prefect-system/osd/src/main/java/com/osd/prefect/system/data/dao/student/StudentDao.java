package com.osd.prefect.system.data.dao.student;

import com.osd.prefect.system.model.student.Student;
import java.util.List;

public interface StudentDao
{
   Student getStudentbyID();
   List<Student> getStudentsbyDepartmentID();
   List<Student> getStudentsBySection();
   List<Student> getStudentsByStudentLevel();
}
