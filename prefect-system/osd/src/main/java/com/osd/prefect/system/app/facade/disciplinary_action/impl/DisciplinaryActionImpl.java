package com.osd.prefect.system.app.facade.disciplinary_action.impl;

import com.osd.prefect.system.app.facade.disciplinary_action.DisciplinaryAction;
import com.osd.prefect.system.data.dao.disciplinary_action.DisciplinaryActionDao;
import com.osd.prefect.system.data.dao.disciplinary_action.impl.DisciplinaryActionDaoImpl;

import java.util.List;

public class DisciplinaryActionImpl implements DisciplinaryAction {
    private final DisciplinaryActionDao disciplinaryActionDao;
    public DisciplinaryActionImpl(){
        disciplinaryActionDao = new DisciplinaryActionDaoImpl();
    }
    @Override
    public List<com.osd.prefect.system.model.disciplinary_action.DisciplinaryAction> getAllDisciplinaryAction() {

        return disciplinaryActionDao.getAllDisciplinaryAction();
    }
}
