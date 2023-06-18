package com.z.apigateway.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域 config
 */
//@Configuration
public class CorsConfig {

//    @Bean
    public CorsFilter corsFilter() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true); // 允许cookie跨域
        configuration.setAllowedOrigins(Lists.newArrayList("*"));
        configuration.setAllowedHeaders(Lists.newArrayList("*"));
        configuration.setAllowedMethods(Lists.newArrayList("*"));
        configuration.setMaxAge(300L);

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
