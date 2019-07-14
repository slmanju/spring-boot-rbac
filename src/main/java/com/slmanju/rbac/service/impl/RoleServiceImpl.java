package com.slmanju.rbac.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slmanju.rbac.domain.Privilege;
import com.slmanju.rbac.domain.Role;
import com.slmanju.rbac.exceptions.NotFoundException;
import com.slmanju.rbac.repository.PriviledgeRepository;
import com.slmanju.rbac.repository.RoleRepository;
import com.slmanju.rbac.service.RoleService;
import com.slmanju.rbac.view.RoleView;
import com.slmanju.rbac.view.RoleViewConvertor;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PriviledgeRepository priviledgeRepository;

    public RoleServiceImpl(RoleRepository roleRepository, PriviledgeRepository priviledgeRepository) {
        this.roleRepository = roleRepository;
        this.priviledgeRepository = priviledgeRepository;
    }

    @Override
    public RoleView save(RoleView roleView) {
        Role role = roleRepository.save(RoleViewConvertor.toRole(roleView));
        return RoleViewConvertor.toRoleView(role);
    }

    @Override
    public RoleView findById(String id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(RoleViewConvertor::toRoleView).orElseThrow(() -> new NotFoundException("Role not found"));
    }

    @Override
    public List<RoleView> findAll() {
        List<Role> roles = roleRepository.findAll();
        return RoleViewConvertor.toRoleViews(roles);
    }

    @Override
    public void delete(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleView addPriviledge(String roleId, String priviledgeid) {
        Role role = roleRepository.findById(roleId).get();
        Privilege privilege = priviledgeRepository.findById(priviledgeid).get();
        role.addPrivilege(privilege);
        roleRepository.save(role);
        return RoleViewConvertor.toRoleView(role);
    }

}
