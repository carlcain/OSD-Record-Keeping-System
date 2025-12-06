package com.osd.prefect.system.app.facade.violation.impl;

import com.osd.prefect.system.app.facade.violation.ViolationFacade;
import com.osd.prefect.system.data.dao.violation.ViolationDao;
import com.osd.prefect.system.data.dao.violation.impl.ViolationDaoImpl;
import com.osd.prefect.system.model.violation.Violation;

import java.util.Date;
import java.util.List;

public class ViolationFacadeImpl implements ViolationFacade {
    private ViolationDao violationDao;
    public ViolationFacadeImpl() {
        this.violationDao = new ViolationDaoImpl();
    }
    @Override
    public List<Violation> getAllViolations() {
        return violationDao.getAllViolations();
    }

    @Override
    public boolean addViolation(String studentId, String prefectID, String offenseID,
                         String actionID, String remarks){
        return violationDao.addViolation(studentId, prefectID, offenseID, actionID, remarks);
    }

    @Override
    public void editViolation(Violation violation) {

    }

    @Override
    public List<Violation> getAllViolationsPerStudent(String studentID) {
        return violationDao.getAllViolationsPerStudent(studentID);
    }
}
