package com.z.apigateway.filter;

import com.google.common.collect.Lists;
import com.z.apigateway.utils.CookieUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

public class AuthFilter implements GlobalFilter, Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final List<String> sellerUrls = Lists.newArrayList("/api/orders/finish");
    private static final List<String> customerUrls = Lists.newArrayList("/api/orders");
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // POST /api/orders 只能customer 访问
        // PUT /api/orders/finsh 只能seller 访问
        // GET /products 所有人都可以访问
        String uriPath = exchange.getRequest().getURI().getPath();
        if (sellerUrls.contains(uriPath)) {
            HttpCookie token = exchange.getRequest().getCookies().getFirst(CookieUtil.TOKEN);
            if (token == null || !StringUtils.hasLength(token.getValue()) || !StringUtils.hasLength(stringRedisTemplate.opsForValue().get(token.getValue()))) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
        }

        if (customerUrls.contains(uriPath)) {
            HttpCookie openid = exchange.getRequest().getCookies().getFirst(CookieUtil.OPENID);
            if (openid == null || !StringUtils.hasLength(openid.getValue())) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
        }

        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
