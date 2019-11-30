package org.papaja.adminfly.commons;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static org.apache.commons.beanutils.PropertyUtils.getProperty;
import static org.apache.commons.beanutils.PropertyUtils.setProperty;

public class DataHolder<T> {

    public static final DataHolder HOLDER      = new DataHolder();
    public static final String     DEFAULT_KEY = "DEFAULT";
    public static final Supplier   DEFAULT     = () -> HOLDER.get(DEFAULT_KEY, null, false);

    public Map<String, T> map = new HashMap<>();
    public String         key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T get(String key) {
        return get(key, () -> get(DEFAULT.get(), key, null, false), true);
    }

    public T get(String key, T defaultValue) {
        return get(map, key, () -> defaultValue, true);
    }

    public T get(String key, Supplier<T> supplier) {
        return get(map, key, supplier, true);
    }

    public T get(String key, Supplier<T> supplier, boolean withPrefix) {
        return get(map, key, supplier, withPrefix);
    }

    public T get(Object bean, String key, Supplier<T> supplier, boolean withPrefix) {
        T value = null;

        try {
            value = (T) ofNullable(getProperty(bean, getKey(key, withPrefix))).orElseGet(supplier);
        } catch (Exception ignore) {
            if (supplier != null) {
                value = get(supplier.get(), key, null, true);
            }
        }

        if (value == null) {
            value = get(DEFAULT.get(), key, null, false);
        }

        return value;
    }

    public void set(String key, T value) {
        set(key, value, true);
    }

    public void set(String key, T value, boolean withPrefix) {
        try {
            setProperty(map, getKey(key, withPrefix), value);
        } catch (Exception ignore) {
        }
    }

    public Collection<T> all() {
        return map.values();
    }

    public void put(String name, T value) {
        map.put(name, value);
    }

    public boolean has(String name) {
        return get(name, null, false) != null;
    }

    private String getKey(String key, boolean withPrefix) {
        return withPrefix ? format("%s.%s", getKey(), key) : key;
    }

}
