package com.z.user.controller;

import com.z.user.common.enums.RoleType;
import com.z.user.common.view.UserView;
import com.z.user.service.UserService;
import com.z.user.utils.CookieUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class LoginController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private UserService userService;

    @GetMapping("/seller/login")
    public ResponseEntity<UserView> sellerLogin(@RequestParam("openid") String openId, HttpServletResponse response, HttpServletRequest request) {
        // is logged
        String token = CookieUtil.get(request, CookieUtil.TOKEN);
        if (StringUtils.hasLength(token) && StringUtils.hasLength(stringRedisTemplate.opsForValue().get(token))) {
            return ResponseEntity.ok(userService.findByOpenId(stringRedisTemplate.opsForValue().get(token)));
        }

        UserView user = userService.findByOpenId(openId);
        if (user == null) {
            return ResponseEntity.notFound().header("error", "user not found").build();
        }
        if (user.getRole() != RoleType.SELLER) {
            return ResponseEntity.badRequest().header("error", "role error").build();
        }
        token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(token, openId, CookieUtil.EXPIRY, TimeUnit.SECONDS);

        CookieUtil.set(response, CookieUtil.TOKEN, token);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/customer/login")
    public ResponseEntity<UserView> customerLogin(@RequestParam("openid") String openId, HttpServletResponse response) {
        UserView user = userService.findByOpenId(openId);
        if (user == null) {
            return ResponseEntity.notFound().header("error", "user not found").build();
        }
        if (user.getRole() != RoleType.CUSTOMER) {
            return ResponseEntity.badRequest().header("error", "role error").build();
        }
        CookieUtil.set(response, CookieUtil.OPENID, openId);
        return ResponseEntity.ok(user);
    }
}
