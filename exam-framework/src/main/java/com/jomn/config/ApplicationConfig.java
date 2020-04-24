package com.jomn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@MapperScan("com.jomn.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class ApplicationConfig {
}
