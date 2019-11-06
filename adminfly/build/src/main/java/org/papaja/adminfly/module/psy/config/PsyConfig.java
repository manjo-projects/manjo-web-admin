package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.ui.Menu;
import org.papaja.adminfly.commons.ui.Modules;
import org.papaja.adminfly.module.psy.commons.holder.PatientHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

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
        menu.addItem("label.tests", "/psy/tests");
        menu.addItem("label.results", "/psy/results");

        Modules.register(new Modules.Module(
                environment.getProperty("module.psy.name"),
                environment.getProperty("module.psy.path"),
                menu
        ));
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public PatientHolder patientHolder() {
        return new PatientHolder();
    }

}
