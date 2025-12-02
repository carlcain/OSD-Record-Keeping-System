package com.osd.prefect.system.data.dao.users;

import com.osd.prefect.system.model.users.User;

public interface UsersDao {
    User getUserByUserID(String UserID);
}
