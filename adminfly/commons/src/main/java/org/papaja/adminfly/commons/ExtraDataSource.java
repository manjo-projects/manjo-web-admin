package org.papaja.adminfly.commons;

import java.util.*;

public enum ExtraDataSource {
    HOLDER;

    public static final  String                           DEFAULT_KEY = "DEFAULT";
    private static final Map<String, Map<String, Object>> SOURCES;

    static {
        SOURCES = new HashMap<>();
    }

    private Map<String, Object> active;

    public List<Object> getListOf(String name) {
        List<Object> values = new ArrayList<>();

        for (Map<String, Object> value : SOURCES.values()) {
            if (value.containsKey(name)) {
                values.add(value.get(name));
            }
        }

        return values;
    }

    public Map<String, Map<String, Object>> getAll() {
        return SOURCES;
    }

    public void add(String name, Map<String, Object> map) {
        SOURCES.put(name, map);
    }

    public boolean has(String name) {
        return SOURCES.containsKey(name);
    }

    public Map<String, Object> getActive() {
        return active;
    }

    public void setActive(String name) {
        this.active = SOURCES.get(name.isEmpty() ? DEFAULT_KEY : name);
    }

}
