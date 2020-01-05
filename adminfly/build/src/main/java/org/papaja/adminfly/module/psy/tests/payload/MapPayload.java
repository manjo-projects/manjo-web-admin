package org.papaja.adminfly.module.psy.tests.payload;

import org.papaja.adminfly.module.psy.tests.Payload;

import java.util.Map;

public class MapPayload<K, V> implements Payload<Map<K, V>> {

    protected Map<K, V> map;

    public MapPayload(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public Map<K, V> getValue() {
        return map;
    }

}
