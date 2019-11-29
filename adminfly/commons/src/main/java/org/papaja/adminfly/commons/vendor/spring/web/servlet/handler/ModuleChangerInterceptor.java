package org.papaja.adminfly.commons.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.commons.ExtraDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

import static java.lang.String.format;

public class ModuleChangerInterceptor extends HandlerInterceptorAdapter {

    private ExtraDataSource source = ExtraDataSource.HOLDER;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        String name = getModuleName(request);

        if (handler instanceof HandlerMethod) {
            if (name.isEmpty() || source.has(name)) {
                source.setActive(name);
            } else {
                throw new AccessDeniedException(
                    format("Unable load module: '%s'. Make sure you configure the module in 'module-info/(%s|*).yaml'",
                        name, name));
            }
        }

        return super.preHandle(request, response, handler);
    }

    private String getModuleName(HttpServletRequest request) {
        String servletPath = request.getServletPath(), moduleName = null;

        if (servletPath.length() > 0) {
            moduleName = servletPath.substring(1);

            if (moduleName.indexOf('/') > 0) {
                moduleName = moduleName.substring(0, moduleName.indexOf('/')).toUpperCase();
            }
        }

        return moduleName;
    }

}
