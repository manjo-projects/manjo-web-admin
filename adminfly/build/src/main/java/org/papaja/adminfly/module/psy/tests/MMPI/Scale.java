package org.papaja.adminfly.module.psy.tests.MMPI;

public enum Scale {

    SCALE_L("L"),
    SCALE_F("F"),
    SCALE_K("K"),
    SCALE_1("Hs", new Correction(0.5f)),
    SCALE_2("D"),
    SCALE_3("Hy"),
    SCALE_4("Pd", new Correction(0.4f)),
    SCALE_5_F("Mf-F", true),
    SCALE_5_M("MM", true),
    SCALE_6("Pa"),
    SCALE_7("Pt", new Correction(1.0f)),
    SCALE_8("Sc", new Correction(1.0f)),
    SCALE_9("Ma", new Correction(0.2f)),
    SCALE_0("Si");

    private boolean    inverted;
    private String     name;
    private Gender     sex;
    private Correction correction;

    Scale(String name, Correction correction, boolean inverted) {
        this.name = name;
        this.correction = correction;
        this.inverted = inverted;
    }

    Scale(String name, Correction correction) {
        this(name, correction, false);
    }

    Scale(String name, boolean inverted) {
        this(name, null, inverted);
    }

    Scale(String name) {
        this(name, null, false);
    }

    public boolean hasK() {
        return correction != null;
    }

    public Correction getCorrection() {
        return correction;
    }

    public boolean isInverted() {
        return inverted;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return getName().toUpperCase();
    }

    public Gender sex() {
        return sex;
    }

    public void sex(Gender sex) {
        this.sex = sex;
    }

}