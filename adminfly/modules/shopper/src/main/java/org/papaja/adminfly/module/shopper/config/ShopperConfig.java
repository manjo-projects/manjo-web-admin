package org.papaja.adminfly.module.shopper.config;

import org.papaja.adminfly.commons.ui.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/shopper/module.properties",
}, ignoreResourceNotFound = true)
public class ShopperConfig {

    protected Environment environment;

    public @Autowired
    ShopperConfig(Environment environment) {
        this.environment = environment;

        Modules.register(new Modules.Module(
                environment.getProperty("module.shopper.name"),
                environment.getProperty("module.shopper.path"),
                null
        ));
    }

}
