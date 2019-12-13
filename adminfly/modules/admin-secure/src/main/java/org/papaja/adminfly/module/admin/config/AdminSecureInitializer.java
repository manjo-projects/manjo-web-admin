package org.papaja.adminfly.module.admin.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AdminSecureInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println(getClass().getName()+".getRootConfigClasses()");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AdminConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/secure/*"};
    }

}
