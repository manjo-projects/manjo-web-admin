package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.ui.Menu;
import org.papaja.adminfly.commons.ui.Modules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/psy/module.properties",
}, ignoreResourceNotFound = true)
public class PsyTestsConfig {

    protected Environment environment;

    public @Autowired
    PsyTestsConfig(Environment environment) {
        this.environment = environment;

        Menu menu = new Menu();

        menu.addItem("label.patients", "/psy-tests/patients");
        menu.addItem("label.tests", "/psy-tests/index");
        menu.addItem("label.results", "/psy-tests/results");

        Modules.register(new Modules.Module(
                environment.getProperty("module.psy.name"),
                environment.getProperty("module.psy.path"),
                menu
        ));
    }

}
