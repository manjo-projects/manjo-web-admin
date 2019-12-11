package org.papaja.adminfly.module.clock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/shopper/module.properties",
}, ignoreResourceNotFound = true)
public class JustClockConfig {

    protected Environment environment;

    public @Autowired
    JustClockConfig(Environment environment) {
        this.environment = environment;
    }

}
