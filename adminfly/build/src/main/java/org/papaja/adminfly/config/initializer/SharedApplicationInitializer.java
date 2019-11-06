package org.papaja.adminfly.config.initializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.util.Random;

public class SharedApplicationInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SharedWebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/shared/*"};
    }

    @Override
    protected String getServletName() {
        return "sharedServlet";
    }

    @ComponentScan(
            basePackages = {
                    "org.papaja.adminfly.config.initializer.web"
            }
    )
    @Configuration
    public class SharedWebConfiguration implements WebMvcConfigurer {

//        @Bean
//        @Scope(value = WebApplicationContext.SCOPE_REQUEST)
//        public Integer randomInt() {
//            System.out.println(getClass().getName());
//            return new Random().nextInt();
//        }

    }



}
