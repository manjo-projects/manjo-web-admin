package org.papaja.adminfly.module.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/blog/module.properties",
}, ignoreResourceNotFound = true)
@ComponentScan(basePackages = {"org.papaja.adminfly.module.blog"})
public class BlogConfig {

    protected Environment environment;

    public @Autowired
    BlogConfig(Environment environment) {
        this.environment = environment;
    }

}
