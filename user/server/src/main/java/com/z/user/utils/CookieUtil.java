package com.z.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class CookieUtil {

    public static final String TOKEN = "token";
    public static final String OPENID = "openid";
    public static final int EXPIRY = 7200;

    public static void set(HttpServletResponse response, String name, String value) {
        set(response, name, value, EXPIRY);
    }

    public static void set(HttpServletResponse response, String name, String value, int expiry) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(expiry);
        response.addCookie(cookie);
    }

    public static String get(HttpServletRequest request, String name) {
        return Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals(name)).map(Cookie::getValue).findFirst().orElse(null);
    }
}
