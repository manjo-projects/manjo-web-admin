package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.annotation.MvcConfiguration;
import org.papaja.adminfly.commons.vendor.spring.web.servlet.handler.LocaleConstraintInterceptor;
import org.papaja.adminfly.module.psy.commons.holder.TestContextHolder;
import org.papaja.adminfly.module.psy.tests.MMPI.Answer;
import org.papaja.adminfly.module.psy.tests.MMPI.WizardFactory;
import org.papaja.adminfly.module.psy.tests.MMPI.Q566.MMPI566Wizard;
import org.papaja.adminfly.module.psy.tests.wizard.Wizard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

import static java.util.Arrays.asList;
import static org.papaja.adminfly.commons.DataHolder.HOLDER;
import static org.papaja.geo.Locale.RU_RU;
import static org.papaja.geo.Locale.UK_UA;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.util.StringUtils.parseLocale;
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeConstraintInterceptor());
    }

    @Bean
    @Scope(value = SCOPE_SESSION, proxyMode = TARGET_CLASS)
    public TestContextHolder.Context contextHolder() {
        return TestContextHolder.getTestContext();
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

    @Bean
    public LocaleConstraintInterceptor localeConstraintInterceptor() {
        Locale            defaultLocale = parseLocale(UK_UA.getCode());
        Supplier<Boolean> predicate     = () -> HOLDER.getKey().equals(MODULE_KEY);
        List<Locale>      locales       = asList(parseLocale(UK_UA.getCode()), parseLocale(RU_RU.getCode()));

        LocaleConstraintInterceptor interceptor = new LocaleConstraintInterceptor(defaultLocale, locales,predicate);

        interceptor.setLocaleParameter("locale");

        return interceptor;
    }

}
