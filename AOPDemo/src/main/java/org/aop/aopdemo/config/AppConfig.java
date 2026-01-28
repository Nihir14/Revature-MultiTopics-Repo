package org.aop.aopdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org/aop/aopdemo/service", "org/aop/aopdemo/aspect"})
@EnableAspectJAutoProxy
public class AppConfig {
}
