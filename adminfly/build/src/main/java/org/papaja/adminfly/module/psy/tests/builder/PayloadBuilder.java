package org.papaja.adminfly.module.psy.tests.builder;

import org.papaja.adminfly.module.psy.tests.Payload;
import org.papaja.adminfly.module.psy.tests.payload.MapPayload;
import org.papaja.adminfly.module.psy.tests.payload.TuplePayload;
import org.papaja.tuple.value.Tuple;

import java.util.Map;

public class PayloadBuilder<T> extends AbstractBuilder<PayloadBuilder, Payload<T>> {

    private static final Payload NULL_PAYLOAD = () -> null;
    private              Payload payload      = NULL_PAYLOAD;

    public PayloadBuilder with(Object value) {
        Payload payload = null;

        if (value != null) {
            Class<?> type = value.getClass();

            if (Map.class.isAssignableFrom(type)) {
                payload = new MapPayload((Map<?, ?>) value);
            } else if (Tuple.class.isAssignableFrom(type)) {
                payload = new TuplePayload((Tuple) value);
            }

            if (payload != null) {
                this.payload = payload;
            }
        }

        return self();
    }

    @Override
    public Payload build() {
        return payload;
    }

}
