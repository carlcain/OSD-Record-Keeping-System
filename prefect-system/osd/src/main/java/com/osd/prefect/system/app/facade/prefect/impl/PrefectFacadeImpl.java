package com.osd.prefect.system.app.facade.prefect.impl;

import com.osd.prefect.system.app.facade.prefect.PrefectFacade;
import com.osd.prefect.system.data.dao.prefect.PrefectDao;
import com.osd.prefect.system.data.dao.prefect.impl.PrefectDaoImpl;
import com.osd.prefect.system.model.prefect.Prefect;

public class PrefectFacadeImpl implements PrefectFacade {
   private PrefectDao prefectDao;

   public PrefectFacadeImpl(){
       this.prefectDao = new PrefectDaoImpl();

   }
    @Override
    public Prefect getPrefectByID(String prefectID) {
        return null;
    }
}
