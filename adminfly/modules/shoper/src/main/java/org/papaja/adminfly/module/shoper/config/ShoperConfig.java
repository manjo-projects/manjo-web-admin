package org.papaja.adminfly.module.kv.config;

import org.papaja.adminfly.commons.data.AdminFlyModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/shoper/module.properties",
}, ignoreResourceNotFound = true)
public class ShoperConfig {

    protected Environment environment;

    public @Autowired
    ShoperConfig(Environment environment) {
        this.environment = environment;

        AdminFlyModules.addModule(
                environment.getProperty("module.shoper.name"),
                environment.getProperty("module.shoper.path")
        );
    }

}
