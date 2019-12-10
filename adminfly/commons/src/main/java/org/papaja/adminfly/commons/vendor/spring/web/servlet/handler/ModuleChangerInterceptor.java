package org.papaja.adminfly.commons.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.commons.DataHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.lang.String.format;

public class ModuleChangerInterceptor extends HandlerInterceptorAdapter {

    private DataHolder source = DataHolder.HOLDER;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        String name = getModuleName(request);

        if (handler instanceof HandlerMethod) {
            if (name.isEmpty() || source.has(name)) {
                source.setKey(name);
            } else {
                throw new AccessDeniedException(
                    format("Access denied to the module: '%s'. Make sure you correctly configure the module in 'resources/**/module.yaml'",
                        name));
            }
        }

        return super.preHandle(request, response, handler);
    }

    private String getModuleName(HttpServletRequest request) {
        String servletPath = request.getServletPath(), moduleName = null;

        if (servletPath.length() > 0) {
            moduleName = servletPath.substring(1);

            System.out.println("getPathKey0: " + getPathKey(servletPath, 0));
            System.out.println("getPathKey1: " + getPathKey(servletPath, 1));

            if (moduleName.indexOf('/') > 0) {
                moduleName = moduleName.substring(0, moduleName.indexOf('/')).toUpperCase();
            }
        }

        return moduleName;
    }

    private String getPathKey(String path, int index) {
        String key = null;

        if (path != null) {
            if (path.startsWith("/")) {
                path = path.substring(1);
            }

            path = path.trim();

            if (!path.isEmpty()) {
                String[] parts = path.split("/");

                if (index < parts.length) {
                    key = parts[index];
                }
            }
        }

        return key == null ? null : key.toUpperCase();
    }

}
