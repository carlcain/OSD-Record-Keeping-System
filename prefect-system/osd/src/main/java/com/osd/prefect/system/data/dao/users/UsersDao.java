package com.osd.prefect.system.data.dao.users;

import com.osd.prefect.system.model.users.User;
import java.util.List;

public interface UsersDao
{
    User getUserbyID(String userId);
    User getUserbyUsername(String username);
    List<User> getUserbyRole(String role);
}
