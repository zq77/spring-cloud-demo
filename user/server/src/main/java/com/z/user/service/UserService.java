package com.z.user.service;

import com.z.user.common.view.UserView;

public interface UserService {
    public UserView findByOpenId(String openId);
}
