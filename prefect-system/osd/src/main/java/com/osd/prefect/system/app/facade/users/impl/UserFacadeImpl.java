package com.osd.prefect.system.app.facade.users.impl;

import com.osd.prefect.system.app.facade.users.UserFacade;
import com.osd.prefect.system.data.dao.users.UsersDao;
import com.osd.prefect.system.data.dao.users.impl.UsersDaoImpl;
import com.osd.prefect.system.model.users.User;

import java.util.List;

public class UserFacadeImpl implements UserFacade {
    private UsersDao usersDao;

    public UserFacadeImpl(){
        this.usersDao = new UsersDaoImpl();
    }

    @Override
    public User getUserbyID(String userId) {
        return null;
    }

    @Override
    public User getUserbyUsername(String username) {
        return usersDao.getUserbyUsername(username);
    }

    @Override
    public List<User> getUserbyRole(String role) {
        return List.of();
    }
}
