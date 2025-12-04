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
    public void addViolation(String studentId, String prefectID, String offenseID, Date dateOfViolation, String actionID, Date dateOfResolution, String remarks, String status) {
    }

    @Override
    public void editViolation(Violation violation) {

    }
}
