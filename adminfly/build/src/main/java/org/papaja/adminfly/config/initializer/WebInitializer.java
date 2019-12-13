package org.papaja.adminfly.config.initializer;

import org.papaja.adminfly.config.CommonConfig;
import org.papaja.adminfly.config.MVCConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings({"unused"})
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public static final String SERVLET_NAME = "WEB-APPLICATION";

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        super.onStartup(context);

        Properties          properties = getApplicationProperties();
        SessionCookieConfig config     = context.getSessionCookieConfig();

        config.setName(properties.getProperty("app.security.session.cookieName"));
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return super.createRootApplicationContext();
    }

    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext context) {
        final DispatcherServlet servlet = (DispatcherServlet) super.createDispatcherServlet(context);

        servlet.setThrowExceptionIfNoHandlerFound(true);

        return servlet;
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{CommonConfig.class,};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        return new Filter[]{filter};
    }

    // @todo unfortunately hardcoded
    private Properties getApplicationProperties() {
        ClassLoader loader     = WebInitializer.class.getClassLoader();
        Properties  properties = new Properties();
        InputStream stream     = new BufferedInputStream(loader.getResourceAsStream("properties/application.properties"));

        try {
            properties.load(stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return properties;
    }

    @Override
    protected String getServletName() {
        return SERVLET_NAME;
    }
}
