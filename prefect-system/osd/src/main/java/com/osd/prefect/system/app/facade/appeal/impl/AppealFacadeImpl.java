package com.osd.prefect.system.app.facade.appeal.impl;

import com.osd.prefect.system.app.facade.appeal.AppealFacade;
import com.osd.prefect.system.data.dao.appeal.AppealDao;
import com.osd.prefect.system.data.dao.appeal.impl.AppealDaoImpl;
import com.osd.prefect.system.model.appeal.Appeal;

import java.util.List;

public class AppealFacadeImpl implements AppealFacade {
    private AppealDao appealDao = new AppealDaoImpl();

    @Override
    public void addAppeal(String violationID, String studentID, String message) {
    appealDao.addAppeal(violationID, studentID, message);
    }

    @Override
    public void updateAppealStatus(String appealID, String status) {
        appealDao.updateAppealStatus(appealID, status);
    }


    @Override
    public List<Appeal> getAllAppeals() {
        return appealDao.getAllAppeals();
    }
}
