package org.papaja.adminfly.commons;

import org.papaja.function.Supplier;

import java.util.*;

import static java.lang.String.format;
import static org.apache.commons.beanutils.PropertyUtils.getProperty;
import static org.apache.commons.beanutils.PropertyUtils.setProperty;

public class ExtraHashMap extends HashMap<String, Object> {

    public static final ExtraHashMap           HOLDER      = new ExtraHashMap();
    public static final String                 DEFAULT_KEY = "DEFAULT";
    public static final Supplier<ExtraHashMap> DEFAULT     = () -> (ExtraHashMap) HOLDER.get(DEFAULT_KEY);
    private String active = DEFAULT_KEY;

    public static ExtraHashMap wrap(Map<String, Object> raw) {
        ExtraHashMap self = new ExtraHashMap();

        raw.forEach((key, value) -> {
            if (value.getClass().isAssignableFrom(Map.class)) {
                self.put(key, wrap(raw));
            } else {
                self.put(key, value);
            }
        });

        return self;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Object get(String key) {
        System.out.println(key);
        return get(key, true);
    }

    public Object get(String key, boolean withPrefix) {
        return get(getKey(key, withPrefix));
    }

    public Object get(String key, Object defaultValue) {
        Object value = defaultValue;

        try {
            value = getProperty(this, key);
        } catch (Exception ignore) {

        } finally {
            if (value == null) {
                value = defaultValue != null ? defaultValue : DEFAULT.get().get(key, null);
            }
        }

        return value;
    }

    public void set(String key, Object value) {
        set(key, value, true);
    }

    public void set(String key, Object value, boolean withPrefix) {
        try {
            setProperty(this, getKey(key, withPrefix), value);
        } catch (Exception ignore) {
        }
    }

    public boolean has(String name) {
        return get(name, null) != null;
    }

    private String getKey(String key, boolean withPrefix) {
        return withPrefix ? format("%s.%s", getActive(), key) : key;
    }

}
