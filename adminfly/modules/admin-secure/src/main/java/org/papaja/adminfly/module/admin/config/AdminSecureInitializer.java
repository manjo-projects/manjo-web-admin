package org.papaja.adminfly.module.admin.config;

import org.papaja.adminfly.commons.vendor.spring.support.AbstractModuleConfigDispatcherServletInitializer;

public class AdminSecureInitializer extends AbstractModuleConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AdminConfig.class};
    }

    @Override
    protected String getModuleName() {
        return "MANAGER";
    }

}
