package com.slmanju.rbac.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.slmanju.rbac.domain.User;

public final class UserViewConvertor {

    public static UserView toUserView(User user) {
        UserView userView = new UserView();
        BeanUtils.copyProperties(user, userView);
        return userView;
    }

    public static User toUser(UserView userView) {
        User user = new User();
        BeanUtils.copyProperties(userView, user);
        return user;
    }

    public static List<UserView> toUserViews(List<User> users) {
        return users.stream().map(UserViewConvertor::toUserView).collect(Collectors.toList());
    }

}
