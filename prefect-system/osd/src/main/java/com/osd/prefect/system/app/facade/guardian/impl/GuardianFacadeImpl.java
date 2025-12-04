package com.osd.prefect.system.app.facade.guardian.impl;

import com.osd.prefect.system.app.facade.guardian.GuardianFacade;
import com.osd.prefect.system.data.dao.guardian.GuardianDao;
import com.osd.prefect.system.data.dao.guardian.impl.GuardianDaoImpl;
import com.osd.prefect.system.model.guardian.Guardian;

public class GuardianFacadeImpl implements GuardianFacade {

    private GuardianDao guardianDao;
    public GuardianFacadeImpl() {
        this.guardianDao = new GuardianDaoImpl();
    }
    @Override
    public Guardian getGuardianByStudentID(String studentID) throws Exception {
        if(guardianDao.getGuardianByStudentID(studentID) == null){
            throw new Exception("Student ID does not exist");
        }
        return guardianDao.getGuardianByStudentID(studentID);
    }
}
