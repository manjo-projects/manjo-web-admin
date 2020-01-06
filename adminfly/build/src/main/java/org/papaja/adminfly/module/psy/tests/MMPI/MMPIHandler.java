package org.papaja.adminfly.module.psy.tests.MMPI;

import org.papaja.adminfly.module.psy.commons.function.Caster;
import org.papaja.adminfly.module.psy.commons.function.Value;
import org.papaja.adminfly.module.psy.tests.Context;
import org.papaja.adminfly.module.psy.tests.Handler;

import java.util.Map;

public class MMPIHandler implements Handler<Map<Scale, Float>, Context> {

    private Context context;

    public MMPIHandler(Context context) {
        this.context = context;
    }

    @Override
    public Value<Map<Scale, Float>> handle(Value value) {

        System.out.println(value.type().getName());
        System.out.println(context.getGender());
        System.out.println(value.get());

        Map<Scale, Integer> values = Caster.cast(value.get(), Map.class);

        values.forEach((scale, integer) -> {
            System.out.println(scale + ":"+integer);
        });

        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }

}
