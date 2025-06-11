package com.puppyshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration                      // lets Spring pick it up at startup
public class CorsCfg implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry r) {
        r.addMapping("/**")                 // expose every endpoint
         .allowedOrigins("http://localhost:3000")  // Next.js dev server
         .allowedMethods("*");              // GET, POST, PUT, DELETE, …
    }
}

