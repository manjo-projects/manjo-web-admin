package org.papaja.adminfly.module.psy.tests.MMPI.handler;

import java.util.Base64;

import static java.lang.String.format;
import static java.util.Base64.getEncoder;

public class MMPIHandlerResult {

    private byte[] chart;
    private String welsh;

    public byte[] getChart() {
        return chart;
    }

    public String getBase64PNGChart() {
        return format("data:image/png;base64,%s", new String(getEncoder().encode(chart)));
    }

    public void setChart(byte[] chart) {
        this.chart = chart;
    }

    public String getWelsh() {
        return welsh;
    }

    public void setWelsh(String welsh) {
        this.welsh = welsh;
    }

}
