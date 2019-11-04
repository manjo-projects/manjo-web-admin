package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.ui.Menu;
import org.papaja.adminfly.commons.ui.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SuppressWarnings({"unused"})
@Configuration
@PropertySource(value = {
        "classpath:properties/module/psy/module.properties",
}, ignoreResourceNotFound = true)
public class PsyConfig {

    protected Environment environment;

    public @Autowired
    PsyConfig(Environment environment) {
        this.environment = environment;

        Menu menu = new Menu();

        menu.addItem("label.patients", "/psy/patients");
        menu.addItem("label.tests", "/psy/index");
        menu.addItem("label.results", "/psy/results");

        Modules.register(new Modules.Module(
                environment.getProperty("module.psy.name"),
                environment.getProperty("module.psy.path"),
                menu
        ));
    }

}
