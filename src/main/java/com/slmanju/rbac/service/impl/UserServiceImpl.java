package com.slmanju.rbac.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slmanju.rbac.domain.Role;
import com.slmanju.rbac.domain.User;
import com.slmanju.rbac.exceptions.NotFoundException;
import com.slmanju.rbac.repository.RoleRepository;
import com.slmanju.rbac.repository.UserRepository;
import com.slmanju.rbac.service.UserService;
import com.slmanju.rbac.view.UserView;
import com.slmanju.rbac.view.UserViewConvertor;

import static com.slmanju.rbac.view.UserViewConvertor.*;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserView save(UserView userView) {
        User user = userRepository.save(toUser(userView));
        return toUserView(user);
    }

    @Override
    public UserView findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserViewConvertor::toUserView).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<UserView> findAll() {
        List<User> users = userRepository.findAll();
        return toUserViews(users);
    }

    @Override
    public UserView update(String id, UserView userView) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserView addRole(String userId, String roleId) {
        User user = userRepository.findById(userId).get();
        Role role = roleRepository.findById(roleId).get();
        user.addRole(role);
        userRepository.save(user);
        return toUserView(user);
    }

}
