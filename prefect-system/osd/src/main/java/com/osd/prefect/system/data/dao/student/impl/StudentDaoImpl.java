package com.osd.prefect.system.data.dao.student.impl;

import com.osd.prefect.system.data.dao.student.StudentDao;
import com.osd.prefect.system.model.student.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    @Override
    public Student getStudentbyID() {
        return null;
    }

    @Override
    public List<Student> getStudentsbyDepartmentID() {
        return List.of();
    }

    @Override
    public List<Student> getStudentsBySection() {
        return List.of();
    }

    @Override
    public List<Student> getStudentsByStudentLevel() {
        return List.of();
    }
}
