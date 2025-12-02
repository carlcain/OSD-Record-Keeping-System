package com.osd.prefect.system.data.dao.users.impl;

import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.model.users.User;

import java.util.List;

public class UsersDaoImpl implements UsersDao
{
    @Override
    public User getUserbyID() {
        return null;
    }

    @Override
    public User getUserbyUsername() {
        return null;
    }

    @Override
    public List<User> getUserbyRole() {
        return List.of();
    }
}
