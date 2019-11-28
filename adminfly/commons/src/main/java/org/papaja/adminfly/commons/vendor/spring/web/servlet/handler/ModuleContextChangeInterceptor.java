package org.papaja.adminfly.commons.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.commons.ExtraDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModuleContextChangeInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ExtraDataSource source;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {

        if (handler instanceof HandlerMethod) {
            source.setActive(getModuleName(request));
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
