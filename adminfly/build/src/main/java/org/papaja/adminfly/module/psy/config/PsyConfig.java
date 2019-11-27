package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.html.Link;
import org.papaja.adminfly.commons.html.Text;
import org.papaja.adminfly.commons.mvc.module.Menu;
import org.papaja.adminfly.commons.mvc.module.Modules;
import org.papaja.adminfly.commons.ui.UIData;
import org.papaja.adminfly.commons.ui.UIDataKeeper;
import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.tests.mmpi2.MMPI2Wizard;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import static org.papaja.adminfly.commons.ui.UIDataKeeper.UI_DATA_KEEPER;

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

        UIData uiData = new UIData();

        uiData.setLabel("Psy-Tests");
        uiData.addLink(new Link(new Text("label.patients", true), "/psy/patients"));
        uiData.addLink(new Link(new Text("label.tests", true), "/psy/tests"));
        uiData.addLink(new Link(new Text("label.results", true), "/psy/results"));
        uiData.addLink(new Link(new Text("label.documents", true), "/psy/documents"));

        UI_DATA_KEEPER.setUIData("PSY", uiData);

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
