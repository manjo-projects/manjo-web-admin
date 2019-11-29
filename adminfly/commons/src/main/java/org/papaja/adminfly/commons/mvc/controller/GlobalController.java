package org.papaja.adminfly.commons.mvc.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.papaja.adminfly.commons.support.SystemLocales;
import org.papaja.adminfly.commons.mvc.module.Modules;
import org.papaja.adminfly.commons.support.SystemThemes;
import org.papaja.adminfly.commons.ExtraDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;

@SuppressWarnings({"unused"})
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalController {

    @Autowired
    private Modules modules;

    @Autowired
    private SystemLocales locales;

    @Autowired
    private SystemThemes themes;

    @Autowired
    private ExtraDataSource source;

    @ExceptionHandler({AccessDeniedException.class})
    public String handleAccessDeniedException(Model model, HttpServletRequest request, Principal principal) {
        model.addAttribute("uri", request.getRequestURI());

        handleRequest(request, model);

        return "errors/access";
    }

    @ExceptionHandler({Exception.class})
    public String handleException(
        Exception exception, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal
    ) {
        String template = "errors/exception";

        model.addAttribute("stack", ExceptionUtils.getStackTrace(exception));
        model.addAttribute("exceptionClass", exception.getClass().getName());
        model.addAttribute("rootMassage", exception.getMessage());

        handleRequest(request, model);

        return template;
    }

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model view) {
        Map<String, Object> extra = source.getActive();

        extra.put("modules", source.getFor("module"));

        view.addAttribute("languages", locales);
        view.addAttribute("themes", themes);
        view.addAttribute("modules", modules);
        view.addAttribute("principal", request.getUserPrincipal());
        view.addAttribute("extra", extra);
    }

}