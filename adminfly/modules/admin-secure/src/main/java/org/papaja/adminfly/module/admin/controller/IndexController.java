package org.papaja.adminfly.module.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @Autowired
    WebApplicationContext webApplicationContext;

    private void processContext() {
        WebApplicationContext rootContext = ContextLoader.getCurrentWebApplicationContext();

        System.out.println("context : " + rootContext);
        for (String beanDefinitionName : rootContext.getBeanDefinitionNames()) {
            System.out.println(">>> bean: " + beanDefinitionName);
        }

        System.out.println("context : " + webApplicationContext);
        for (String beanDefinitionName : webApplicationContext.getBeanDefinitionNames()) {
            System.out.println(">>> bean: " + beanDefinitionName);
        }
    }

    @PreAuthorize("hasAnyAuthority('READ')")
    @GetMapping("/test")
    public ModelAndView test() {
        return new ModelAndView("test");
    }

    @GetMapping("/hello")
    public String index() {
        processContext();

        return getClass().getName();
    }

}
