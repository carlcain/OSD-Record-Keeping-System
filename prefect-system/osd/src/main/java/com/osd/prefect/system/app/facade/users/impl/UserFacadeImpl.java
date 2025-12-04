package com.osd.prefect.system.app.facade.users.impl;

import com.osd.prefect.system.app.facade.student.impl.StudentFacadeImpl;
import com.osd.prefect.system.app.facade.users.UserFacade;
import com.osd.prefect.system.data.dao.student.StudentDao;
import com.osd.prefect.system.data.dao.student.impl.StudentDaoImpl;
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
        return null;
    }

    @Override
    public List<User> getUserbyRole(String role) {
        return List.of();
    }
}
