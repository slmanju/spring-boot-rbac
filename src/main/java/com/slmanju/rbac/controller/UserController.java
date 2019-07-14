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

import com.slmanju.rbac.service.UserService;
import com.slmanju.rbac.view.UserView;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserView save(@RequestBody UserView userView) {
        return userService.save(userView);
    }

    @GetMapping("/{id}")
    public UserView findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserView> findAll() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public UserView update(@PathVariable String id, @RequestBody UserView userView) {
        return userService.update(id, userView);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @PutMapping("/{userId}/role/{roleId}")
    public UserView addRole(@PathVariable String userId, @PathVariable String roleId) {
        return userService.addRole(userId, roleId);
    }

}
