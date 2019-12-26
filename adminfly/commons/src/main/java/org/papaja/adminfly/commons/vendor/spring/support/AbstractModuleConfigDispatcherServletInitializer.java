package org.papaja.adminfly.commons.vendor.spring.support;

import org.papaja.adminfly.commons.vendor.spring.web.filter.UTF8EncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

import static java.lang.String.format;

abstract public class AbstractModuleConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String PROJECT_SUFFIX_NAME = "PAPAJA-ADMINFLY";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected String getServletName() {
        return format("%s-%s", getModuleName(), PROJECT_SUFFIX_NAME);
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {
                format("/%s", getModuleName().toLowerCase()), format("/%s/*", getModuleName().toLowerCase())
        };
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
          new UTF8EncodingFilter(),
        };
    }

    abstract protected String getModuleName();

}
