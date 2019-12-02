package org.papaja.adminfly.module.bookkeeper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/bookkeeper/module.properties",
}, ignoreResourceNotFound = true)
public class BookKeeperConfig {

    protected Environment environment;

    public @Autowired
    BookKeeperConfig(Environment environment) {
        this.environment = environment;
    }

}
