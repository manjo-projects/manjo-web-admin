package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.annotation.MvcConfiguration;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.MMPI566Wizard;
import org.papaja.adminfly.module.psy.tests.MMPI.WizardFactory;
import org.papaja.adminfly.module.psy.tests.SessionContext;
import org.papaja.adminfly.module.psy.tests.builder.context.SessionDetailsContextBuilder;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

@SuppressWarnings({"unused"})
@MvcConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource(value = {
        "classpath:properties/module/psy/module.properties"
}, ignoreResourceNotFound = true)
@ComponentScan(basePackages = {"org.papaja.adminfly.module.psy"})
public class PsyConfig implements WebMvcConfigurer {

    private static final String MODULE_KEY = "PSY";

    protected Environment environment;

    public @Autowired
    PsyConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Scope(value = SCOPE_SESSION, proxyMode = TARGET_CLASS)
    public SessionContext sessionContext() {
        return new SessionDetailsContextBuilder().build();
    }

    @Bean("wizardMMPI2")
    @Scope(value = SCOPE_SESSION, proxyMode = TARGET_CLASS)
    public Wizard<Answer> wizardMMPI2() {
        return new MMPI566Wizard();
    }

    @Bean
    @Scope(value = SCOPE_SESSION, proxyMode = TARGET_CLASS)
    public WizardFactory testWizardFactory() {
        return new WizardFactory();
    }

}
