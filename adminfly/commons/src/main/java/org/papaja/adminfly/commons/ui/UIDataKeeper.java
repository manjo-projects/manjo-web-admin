package org.papaja.adminfly.commons.ui;

import java.util.HashMap;
import java.util.Map;

public enum UIDataKeeper {
    UI_DATA_KEEPER();

    private UIData              active = UIData.DEFAULT_UI_DATA;
    private Map<String, UIData> uiData;

    UIDataKeeper() {
        this.uiData = new HashMap<>();
    }

    public void toggle(String name) {
        if (uiData.containsKey(name = name.toUpperCase())) {
            setActive(uiData.get(name));
        } else {
            setActive(UIData.DEFAULT_UI_DATA);
        }
    }

    public UIData getActive() {
        return active;
    }

    public void setActive(UIData active) {
        this.active = active;
    }

    public void setUIData(String name, UIData uiData) {
        this.uiData.put(name.toUpperCase(), uiData);
    }

}
