package com.slmanju.rbac.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.slmanju.rbac.domain.Role;

public final class RoleViewConvertor {

    public static RoleView toRoleView(Role role) {
        RoleView roleView = new RoleView();
        BeanUtils.copyProperties(role, roleView);
        return roleView;
    }

    public static Role toRole(RoleView roleView) {
        Role role = new Role();
        BeanUtils.copyProperties(roleView, role);
        return role;
    }

    public static List<RoleView> toRoleViews(List<Role> users) {
        return users.stream().map(RoleViewConvertor::toRoleView).collect(Collectors.toList());
    }

}
