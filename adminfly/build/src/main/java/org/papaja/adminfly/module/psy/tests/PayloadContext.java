package org.papaja.adminfly.module.psy.tests;

public interface PayloadContext<V> extends PayloadAware<V>, Context {

    String NAME = PayloadContext.class.getCanonicalName();

    default Payload<V> getPayload() {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "getPayload");
    }

    default void setPayload(Payload<V> payload) {
        throw UNSUPPORTED_OPERATION_EXCEPTION.apply(NAME, "setPayload");
    }

    default boolean hasPayload() {
        return getPayload() != null;
    }

}
