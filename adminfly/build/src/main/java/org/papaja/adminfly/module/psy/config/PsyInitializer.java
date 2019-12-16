package org.papaja.adminfly.module.psy.config;

import org.papaja.adminfly.commons.vendor.spring.support.AbstractModuleConfigDispatcherServletInitializer;

public class PsyInitializer extends AbstractModuleConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {PsyConfig.class};
    }

    @Override
    protected String getModuleName() {
        return "PSY";
    }

}
