package org.papaja.adminfly.commons.html;

public class Text {

    private String  value;
    private boolean translatable;

    public Text(String value, boolean translatable) {
        this.value = value;
        this.translatable = translatable;
    }

    public Text(String value) {
        this(value, false);
    }

    public String getValue() {
        return value;
    }

    public boolean isTranslatable() {
        return translatable;
    }

    @Override
    public String toString() {
        return value;
    }

}
