package org.papaja.adminfly.module.psy.tests.MMPI.group;

import org.papaja.adminfly.module.psy.tests.MMPI.Scale;

import static org.papaja.adminfly.module.psy.tests.MMPI.Scale.*;

public class MMPIDefaultScaleGroup extends AbstractScaleGroup {

    public MMPIDefaultScaleGroup() {
        super(new Scale[] {
                SCALE_0,
                SCALE_1,
                SCALE_2,
                SCALE_3,
                SCALE_4,
                SCALE_5_F,
                SCALE_5_M,
                SCALE_6,
                SCALE_7,
                SCALE_8,
                SCALE_9,
        });
    }

}
