package org.papaja.adminfly.commons;

import java.util.HashMap;
import java.util.Map;

public class ExtraDataSource {

    private static final Map<String, Map<String, Object>> SOURCES;

    static {
        SOURCES = new HashMap<>();
    }

    private Map<String, ?> active;

    public Map<String, ?> getActive() {
        return active;
    }

    public void setActive(String name) {
        this.active = SOURCES.get(name);
    }

}
