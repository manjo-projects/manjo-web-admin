package org.papaja.adminfly.commons.mvc.controller;

import org.papaja.adminfly.commons.ui.FlashMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@Controller
@SuppressWarnings({"unused"})
abstract public class AbstractController {

    @Autowired
    protected FlashMessageService messages;

    protected String prefix;

    protected String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters);
    }

    protected ModelAndView newView(String view) {
        return new ModelAndView(normalizeViewPath(view));
    }

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private String normalizeViewPath(String view) {
        return format("%s/%s", getPrefix(), (view.startsWith("/") ? view.substring(1) : (view.isEmpty() ? null : view)));
    }

    protected String getPrefix() {
        String prefix = this.prefix;

        if (isNull(prefix)) {
            RequestMapping annotation = this.getClass().getAnnotation(RequestMapping.class);
            List<String>   mapping    = Arrays.asList(annotation.value());

            prefix = mapping.size() > 0 ? mapping.get(0) : null;
        }

        return prefix;
    }

    protected ModelAndView newRedirect(String view) {
        return new ModelAndView(format("redirect:%s", normalizeViewPath(view)));
    }

    protected RedirectView newRedirectView(String view) {
        return new RedirectView(normalizeViewPath(view));
    }

}
