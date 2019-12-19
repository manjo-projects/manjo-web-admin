package org.papaja.adminfly.commons.mvc.controller;

import org.papaja.adminfly.commons.ui.FlashMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.springframework.util.StringUtils.trimLeadingCharacter;
import static org.springframework.util.StringUtils.trimTrailingCharacter;

@Controller
@SuppressWarnings({"unused"})
abstract public class AbstractController {

    protected static final String DEFAULT_PREFIX = "";
    protected static final String NULL_PREFIX    = null;

    @Autowired
    protected FlashMessageService messages;
    @Autowired
    protected HttpServletRequest  request;
    protected String              prefix = NULL_PREFIX;

    protected String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters);
    }

    private String getMAViewRoute(String view) {
        return getMAViewRoute(getSubPrefix(), trimLeadingCharacter(view, '/'));
    }

    private String getMAViewRoute(String prefix, String view) {
        return format("%s/%s", trimTrailingCharacter(prefix, '/'), view);
    }

    private String getRedirectRoute(String view) {
        return format("/%s/%s", getSubPath(), trimLeadingCharacter(view, '/'));
    }

    protected String getSubPath() {
        return substringBefore(trimLeadingCharacter(request.getServletPath(), '/'), "/");
    }

    protected String getSubPrefix() {
        String prefix = ofNullable(this.prefix).orElseGet(String::new);

        prefix = format("%s/%s",
                LOWER_HYPHEN.to(UPPER_UNDERSCORE, getSubPath()), trimLeadingCharacter(prefix, '/')
        );

        return prefix;
    }

    protected void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    protected void setDefaultPrefix() {
        this.prefix = DEFAULT_PREFIX;
    }

    protected void setNullPrefix() {
        this.prefix = NULL_PREFIX;
    }

    protected ModelAndView newView(String view) {
        return new ModelAndView(getMAViewRoute(view));
    }

    protected ModelAndView newView(String view, String prefix) {
        return new ModelAndView(getMAViewRoute(view, prefix));
    }

    protected ModelAndView newRedirect(String view) {
        return new ModelAndView(format("redirect:%s", getRedirectRoute(view)));
    }

    protected RedirectView newRedirectView(String view) {
        return new RedirectView(getRedirectRoute(view));
    }

}