package com.z.apigateway.utils;


import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Collection;

public class CookieUtil {

    public static final String TOKEN = "token";
    public static final String OPENID = "openid";
    public static final int EXPIRY = 7200;

    public static String get(ServerHttpRequest request, String name) {
        return request.getCookies().values().stream().flatMap(Collection::stream)
                .filter(cookie -> cookie.getName().equals(name)).map(HttpCookie::getValue)
                .findFirst().orElse(null);
    }
}