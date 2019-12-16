package org.papaja.adminfly.commons.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.commons.pojo.FlashMessage;
import org.papaja.adminfly.commons.ui.FlashMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.web.servlet.support.RequestContextUtils.getOutputFlashMap;
import static org.springframework.web.servlet.support.RequestContextUtils.saveOutputFlashMap;

public class LocaleConstraintInterceptor extends HandlerInterceptorAdapter {

    private static String LOCALE_PARAMETER = "_locale";

    private List<Locale>      locales = new ArrayList<>();
    private Locale            defaultLocale;
    private Supplier<Boolean> predicate;

    @Autowired
    private FlashMessageService messages;

    public LocaleConstraintInterceptor(Locale defaultLocale, List<Locale> locales, Supplier<Boolean> predicate) {
        this.defaultLocale = defaultLocale;
        this.locales.addAll(locales);
        this.predicate = predicate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//        Locale locale = getLocale();
//
//        if (!locales.contains(defaultLocale)) {
//            throw new IllegalArgumentException(format("The default locale '%s' must be contained in the passed allowed locales",
//                    defaultLocale.getDisplayLanguage()));
//        }
//
//        if (predicate.get() && !locales.contains(locale)) {
//            String       language = defaultLocale.toLanguageTag().replace('-', '_');
//            String       redirect = format("%s?%s=%s", request.getServletPath(), LOCALE_PARAMETER, language);
//            FlashMessage message  = messages.getErrorMessage("text.unavailableLocale", locale.getDisplayLanguage(),
//                    format("(%s)", getLocalesNames()));
//
//            getOutputFlashMap(request).put("message", message);
//            saveOutputFlashMap(redirect, request, response);
//
//            response.sendRedirect(redirect);
//        }

        return true;
    }

    public void setAllowedLocales(Locale... locale) {
        locales.addAll(asList(locale));
    }

    public void setLocaleParameter(String parameter) {
        LOCALE_PARAMETER = parameter;
    }

    private String getLocalesNames() {
        return join(", ", locales.stream().map(Locale::getDisplayLanguage).collect(toList()));
    }

}
