package org.papaja.adminfly.config.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import java.util.Random;

public class SharedApplicationInitializer
        /*extends AbstractDispatcherServletInitializer*/ {

    //@Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext normalWebAppContext = new AnnotationConfigWebApplicationContext();
        normalWebAppContext.register(SharedWebConfiguration.class);
        return normalWebAppContext;
    }

    //@Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    //@Override
    protected String[] getServletMappings() {
        return new String[]{"/shared/*"};
    }

    //@Override
    protected String getServletName() {
        return "sharedServlet";
    }

    public static class SharedWebConfiguration implements WebMvcConfigurer {

        @Bean
        @Scope(value = WebApplicationContext.SCOPE_REQUEST)
        public Integer randomInt() {
            System.out.println(getClass().getName());
            return new Random().nextInt();
        }

    }

    @Controller("sharedServletIndexController")
    public static class SharedController {

        @Autowired
        private ApplicationContext context;

        @Autowired
        @Qualifier("mvcViewResolver")
        private ViewResolver resolver;

        @Autowired
        @Qualifier("viewResolver")
        private ViewResolver resolver2;

        public SharedController() {
            System.out.println(getClass().getName());
        }

        @GetMapping("/hello")
        @ResponseBody
        public String execute() {

            System.out.println(resolver.getClass().getName());
            System.out.println(">>>>>>>>>");

            System.out.println(resolver2.getClass().getName());
            System.out.println(">>>>>>>>>");

            for (String beanDefinitionName : context.getBeanDefinitionNames()) {
                System.out.println(beanDefinitionName);
            }

            if (null != context.getParent()) {
                System.out.println(">>>>> root");
                for (String definitionName : context.getParent().getBeanDefinitionNames()) {
                    System.out.println(definitionName);
                }
            }

            return getClass().getName();
        }

    }


}
