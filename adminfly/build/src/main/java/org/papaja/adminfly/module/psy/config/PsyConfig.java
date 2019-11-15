package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.ui.Menu;
import org.papaja.adminfly.commons.ui.Modules;
import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.tests.mmpi2.MMPI2Wizard;
import org.papaja.adminfly.module.psy.tests.mmpi2.model.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
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
        menu.addItem("label.documents", "/psy/documents");

        Modules.register(new Modules.Module(
                environment.getProperty("module.psy.name"),
                environment.getProperty("module.psy.path"),
                menu
        ));
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TestContextHolder.Context contextHolder() {
        return TestContextHolder.getTestContext();
    }

    @Bean("wizardMMPI2")
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Wizard<Answer> wizardMMPI2() {
        return new MMPI2Wizard();
    }

}
