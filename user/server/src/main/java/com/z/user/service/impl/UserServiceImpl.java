package com.z.user.service.impl;

import com.z.user.common.view.UserView;
import com.z.user.repository.UserRepository;
import com.z.user.service.UserService;
import com.z.user.utils.UserConvertor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserView findByOpenId(String openId) {
        return UserConvertor.toView(userRepository.findByOpenId(openId));
    }
}
