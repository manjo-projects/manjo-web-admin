package org.papaja.adminfly.module.psy.tests.MMPI.group;

import org.papaja.adminfly.module.psy.tests.MMPI.Scale;
import org.papaja.tuple.Pair;

import static org.papaja.adminfly.module.psy.tests.MMPI.Scale.*;

public class AbstractScaleGroup extends Pair<Scale[], Scale[]> {

    public AbstractScaleGroup(Scale[] groupB) {
        super(new Scale[] {SCALE_L, SCALE_F, SCALE_K}, groupB);
    }

    public Scale[] getGroupA() {
        return getA();
    }

    public Scale[] getGroupB() {
        return getB();
    }

}
