package com.slmanju.rbac.service;

import java.util.List;

import com.slmanju.rbac.view.RoleView;

public interface RoleService {

    RoleView save(RoleView roleView);

    RoleView findById(String id);

    List<RoleView> findAll();

    void delete(String id);

    RoleView addPriviledge(String roleId, String priviledgeid);

}
