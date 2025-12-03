package com.osd.prefect.system.data.dao.prefect;

import com.osd.prefect.system.model.prefect.Prefect;

public interface PrefectDao {
    Prefect getPrefectByID(String prefectID);
}
