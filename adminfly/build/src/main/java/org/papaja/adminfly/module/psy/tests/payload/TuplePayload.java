package org.papaja.adminfly.module.psy.tests.payload;

import org.papaja.adminfly.module.psy.tests.Payload;
import org.papaja.tuple.value.Tuple;

public class TuplePayload<T extends Tuple> implements Payload<T> {

    protected T tuple;

    public TuplePayload(T tuple) {
        this.tuple = tuple;
    }

    @Override
    public T getValue() {
        return tuple;
    }

}
