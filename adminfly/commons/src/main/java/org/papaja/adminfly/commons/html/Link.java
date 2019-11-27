package org.papaja.adminfly.commons.html;

public class Link {

    private static final String DEFAULT_PATH = "#";

    private Text   text;
    private String path;

    public Link(Text text, String path) {
        this.text = text;
        this.path = path;
    }

    public Link(Text text) {
        this(text, DEFAULT_PATH);
    }

    public Link(String text, String path) {
        this(new Text(text), path);
    }

    public Link(String text) {
        this(new Text(text), DEFAULT_PATH);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
