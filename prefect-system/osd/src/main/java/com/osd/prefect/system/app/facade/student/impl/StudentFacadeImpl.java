package com.osd.prefect.system.app.facade.student.impl;

import com.osd.prefect.system.app.facade.student.StudentFacade;
import com.osd.prefect.system.data.dao.student.StudentDao;
import com.osd.prefect.system.data.dao.student.impl.StudentDaoImpl;
import com.osd.prefect.system.model.student.Student;

import java.util.List;

public class StudentFacadeImpl implements StudentFacade {
    private StudentDao studentDao;

    public StudentFacadeImpl() {
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public Student getStudentByID(String userID) {
        return studentDao.getStudentByID(userID);
    }

    @Override
    public List<Student> getStudentsByDepartmentID() {
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

