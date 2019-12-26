package org.papaja.adminfly.module.blog.config;

import org.papaja.adminfly.commons.vendor.spring.support.AbstractModuleConfigDispatcherServletInitializer;

public class BlogViewerInitializer extends AbstractModuleConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {BlogConfig.class};
    }

    @Override
    protected String getModuleName() {
        return "BLOG";
    }

}
