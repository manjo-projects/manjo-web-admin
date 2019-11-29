package org.papaja.adminfly.commons;

import java.util.*;

public class ExtraDataSource {

    public static final  String                           DEFAULT_KEY = "DEFAULT";
    private static final Map<String, Map<String, Object>> SOURCES;

    static {
        SOURCES = new HashMap<>();
    }

    private Map<String, Object> active;

    public List<Map<String, Object>> getFor(String name) {
        List<Map<String, Object>> values = new ArrayList<>();

        for (Map<String, Object> value : SOURCES.values()) {
            values.add(value);
        }

        return values;
    }

    public Map<String, Map<String, Object>> getAll() {
        return SOURCES;
    }

    public void add(String name, Map<String, Object> map) {
        SOURCES.put(name, map);
    }

    public void setActive(String name) {
        this.active = SOURCES.get(name);
    }

    public Map<String, Object> getActive() {
        return active;
    }

}
