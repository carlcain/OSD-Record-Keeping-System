package com.osd.prefect.system.app.facade.offense.impl;

import com.osd.prefect.system.app.facade.offense.OffenseFacade;
import com.osd.prefect.system.data.dao.offense.OffenseDao;
import com.osd.prefect.system.data.dao.offense.impl.OffenseDaoImpl;
import com.osd.prefect.system.model.offense.Offense;

import java.util.List;

public class OffenseFacadeImpl implements OffenseFacade {
    private OffenseDao offenseDao;
    public OffenseFacadeImpl(OffenseDao offenseDao) {
        offenseDao = new OffenseDaoImpl();
    }
    @Override
    public List<Offense> getAllOffense() {
        return offenseDao.getAllOffense();
    }
}
