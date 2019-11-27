package org.papaja.adminfly.module.blog.config;

import org.papaja.adminfly.commons.mvc.module.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/blog/module.properties",
}, ignoreResourceNotFound = true)
public class BlogConfig {

    protected Environment environment;

    public @Autowired
    BlogConfig(Environment environment) {
        this.environment = environment;

        Modules.register(new Modules.Module(
                environment.getProperty("module.blog.name"),
                environment.getProperty("module.blog.path"),
                null
        ));
    }

}
