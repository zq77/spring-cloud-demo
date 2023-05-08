package com.z.user.utils;

import com.z.user.common.view.UserView;
import com.z.user.model.User;

public final class UserConvertor {
    public static UserView toView(User user) {
        if (user == null) {
            return null;
        }
        UserView view = new UserView();
        view.setId(user.getId());
        view.setUsername(user.getUsername());
        view.setPassword(user.getPassword());
        view.setOpenId(user.getOpenId());
        view.setRole(user.getRole());
        return view;
    }
}
