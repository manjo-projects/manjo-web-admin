package org.papaja.adminfly.module.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

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

    @GetMapping("/hello")
    public String index() {
        processContext();

        return getClass().getName();
    }

}
