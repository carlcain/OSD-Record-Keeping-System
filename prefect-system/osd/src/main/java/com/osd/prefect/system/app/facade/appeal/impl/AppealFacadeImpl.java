package com.osd.prefect.system.app.facade.appeal.impl;

import com.osd.prefect.system.app.facade.appeal.AppealFacade;
import com.osd.prefect.system.data.dao.appeal.AppealDao;
import com.osd.prefect.system.data.dao.appeal.impl.AppealDaoImpl;
import com.osd.prefect.system.model.appeal.Appeal;

public class AppealFacadeImpl implements AppealFacade {
    private AppealDao appealDao = new AppealDaoImpl();

    @Override
    public Appeal addAppeal(String violationID, String studentID, String message) {

        return null;
    }

    @Override
    public void editAppealStatus(Appeal appeal, String status) {

    }
}
