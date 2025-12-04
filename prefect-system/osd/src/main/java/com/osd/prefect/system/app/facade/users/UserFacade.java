package com.osd.prefect.system.app.facade.users;

import com.osd.prefect.system.model.users.User;

import java.util.List;

public interface UserFacade {

    User getUserbyID(String userId);
    User getUserbyUsername(String username);
    List<User> getUserbyRole(String role);
}
