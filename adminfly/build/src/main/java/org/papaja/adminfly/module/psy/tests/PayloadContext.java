package org.papaja.adminfly.module.psy.tests;

import static org.papaja.adminfly.module.psy.tests.Context.UNSUPPORTED_OPERATION_EXCEPTION;

public interface PayloadContext<V> extends PayloadAware<V> {

    String NAME = PayloadContext.class.getCanonicalName();

    default Payload getPayload() {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "getPayload");
    }

    default void setPayload(Payload payload) {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "setPayload");
    }

}
