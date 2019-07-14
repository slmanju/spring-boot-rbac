package com.slmanju.rbac.service;

import java.util.List;

import com.slmanju.rbac.view.UserView;

public interface UserService {

    UserView save(UserView userView);

    UserView findById(String id);

    List<UserView> findAll();

    UserView update(String id, UserView userView);

    void delete(String id);

    UserView addRole(String userId, String roleId);

}
