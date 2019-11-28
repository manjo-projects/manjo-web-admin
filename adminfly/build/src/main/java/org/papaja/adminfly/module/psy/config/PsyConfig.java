package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.tests.mmpi2.MMPI2Wizard;
import org.papaja.adminfly.module.psy.tests.mmpi2.data.Answer;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

@SuppressWarnings({"unused"})
@Configuration
@PropertySource(value = {
        "classpath:properties/module/psy/module.properties"
}, ignoreResourceNotFound = true)
public class PsyConfig {

    protected Environment environment;

    public @Autowired
    PsyConfig(Environment environment) {
        this.environment = environment;
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
