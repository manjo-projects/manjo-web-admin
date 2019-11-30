package org.papaja.adminfly.commons.mvc.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.papaja.adminfly.commons.DataHolder;
import org.papaja.adminfly.commons.support.SystemLocales;
import org.papaja.adminfly.commons.support.SystemThemes;
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

@SuppressWarnings({"unused"})
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalController {

    @Autowired
    private SystemLocales locales;

    @Autowired
    private SystemThemes themes;

    @Autowired
    private DataHolder extra;

    @ExceptionHandler({AccessDeniedException.class})
    public String handleAccessDeniedException(
            Exception exception,
            Model model, HttpServletRequest request, Principal principal
    ) {
        model.addAttribute("uri", request.getRequestURI());
        model.addAttribute("message", exception.getMessage());

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
        view.addAttribute("languages", locales);
        view.addAttribute("themes", themes);
        view.addAttribute("principal", request.getUserPrincipal());
        view.addAttribute("extra", extra);
    }

}
