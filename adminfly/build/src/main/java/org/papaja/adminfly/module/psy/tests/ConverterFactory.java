package org.papaja.adminfly.module.psy.tests;

public interface ConverterFactory<C extends ResultConverter, P extends Payload> {
    C createConverter(P payload);
}
