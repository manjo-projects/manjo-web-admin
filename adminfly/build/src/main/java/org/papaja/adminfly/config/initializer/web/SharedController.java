package org.papaja.adminfly.config.initializer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;

@Controller("sharedServletIndexController")
public class SharedController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    @Qualifier("mvcViewResolver")
    private ViewResolver resolver;



//    @Autowired
//    @Qualifier("viewResolver")
//    private ViewResolver resolver2;

    public SharedController() {
        System.out.println(getClass().getName());
    }

    @GetMapping("/hello")
    @ResponseBody
    public String execute() {

        System.out.println(resolver.getClass().getName());
        System.out.println(">>>>>>>>>");

//        System.out.println(resolver2.getClass().getName());
//        System.out.println(">>>>>>>>>");

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