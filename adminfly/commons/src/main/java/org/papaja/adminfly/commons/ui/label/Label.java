package org.papaja.adminfly.commons.ui.label;

import org.papaja.adminfly.commons.html.Text;

public class Label {

    private Text logo;

    public Label() {}

    public Label(Text logo) {
        this.logo = logo;
    }

    public Label(String logo) {
        this.logo = new Text(logo);
    }

    public Text getLogo() {
        return logo;
    }

    public void setLogo(Text logo) {
        this.logo = logo;
    }

}
