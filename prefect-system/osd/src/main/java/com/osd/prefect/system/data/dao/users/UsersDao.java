package com.osd.prefect.system.data.dao.users;

import com.osd.prefect.system.model.users.User;
import java.util.List;

public interface UsersDao
{
    User getUserbyID();
    User getUserbyUsername();
    List<User> getUserbyRole();
}
