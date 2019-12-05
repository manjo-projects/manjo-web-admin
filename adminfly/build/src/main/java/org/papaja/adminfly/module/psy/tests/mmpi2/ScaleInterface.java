package org.papaja.adminfly.module.psy.tests.mmpi2;

public interface ScaleInterface {

    boolean hasK();

    Scale.K getK();

    boolean isInverted();

    String getName();

    String getKey();

    Sex sex();

    void sex(Sex sex);

}
