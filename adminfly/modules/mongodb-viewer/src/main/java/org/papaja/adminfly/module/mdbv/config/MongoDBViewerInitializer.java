package org.papaja.adminfly.module.mdbv.config;

import org.papaja.adminfly.commons.vendor.spring.support.AbstractModuleConfigDispatcherServletInitializer;

public class MongoDBViewerInitializer extends AbstractModuleConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MongoDBViewerConfig.class};
    }

    @Override
    protected String getModuleName() {
        return "MONGODB-VIEWER";
    }

}
