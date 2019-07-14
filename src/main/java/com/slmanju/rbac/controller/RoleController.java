package com.slmanju.rbac.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slmanju.rbac.service.RoleService;
import com.slmanju.rbac.view.RoleView;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public RoleView save(@RequestBody RoleView roleView) {
        return roleService.save(roleView);
    }

    @GetMapping("/{id}")
    public RoleView findById(@PathVariable String id) {
        return roleService.findById(id);
    }

    @GetMapping
    public List<RoleView> findAll() {
        return roleService.findAll();
    }

//    @PutMapping("/{id}")
//    public RoleView update(@PathVariable String id, @RequestBody RoleView roleView) {
//        return roleService.update(id, roleView);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        roleService.delete(id);
    }

    @PutMapping("/{roleId}/priviledge/{priviledgeId}")
    public RoleView addPriviledge(@PathVariable String roleId, @PathVariable String priviledgeId) {
        return roleService.addPriviledge(roleId, priviledgeId);
    }

}
