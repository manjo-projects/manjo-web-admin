package org.papaja.adminfly.commons.beans;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static java.lang.String.format;

@Service
public class SafePropertyUtilsBean {

    private static final PropertyUtilsBean PROPERTY_UTILS_BEAN;
    private static final Logger            LOGGER;

    static {
        PROPERTY_UTILS_BEAN = new PropertyUtilsBean();
        LOGGER = Logger.getLogger(SafePropertyUtilsBean.class.getName());
    }

    public Object getProperty(Object bean, String name) {
        Object value = null;

        try {
            value = PROPERTY_UTILS_BEAN.getProperty(bean, name);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.warning(() -> format("Unable to fetch property value by path: '%s'", name));
        }

        return value;
    }

    public Object getProperty(Object bean, String name, Supplier<Object> defaultValue) {
        Object value = getProperty(bean, name);

        if (value == null) {
            value = defaultValue != null ? defaultValue.get() : null;
        }

        return value;
    }

    public Object getProperty(Object bean, String name, Object defaultValue) {
        return getProperty(bean, name, () -> defaultValue);
    }

}
