package org.papaja.adminfly.commons.ui;

// ui.data.label.get('logo')

import org.papaja.adminfly.commons.html.Link;
import org.papaja.adminfly.commons.html.Text;
import org.papaja.adminfly.commons.ui.label.Label;
import org.papaja.adminfly.commons.ui.link.Links;

public class UIData {

    public static final UIData DEFAULT_UI_DATA = new UIData() {{
        setLabel(new Label());
        addLink(new Link(new Text("title.home", true), "/"));
    }};

    private Label label;
    private Links links;

    public UIData() {
        this.label = new Label();
        this.links = new Links();
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = new Label(label);
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

}
