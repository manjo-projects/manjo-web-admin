package org.papaja.adminfly.module.psy.tests;

import static org.papaja.adminfly.module.psy.tests.Context.UNSUPPORTED_OPERATION_EXCEPTION;

public interface PayloadContext<V> extends PayloadAware<V> {

    default Payload getPayload() {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(getClass().getCanonicalName(), "getPayload");
    }

    default void setPayload(Payload payload) {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(getClass().getCanonicalName(), "setPayload");
    }

}
