package org.papaja.adminfly.module.psy.tests;

public interface ConverterFactory<R extends ResultConverter, C extends Context> {
    R createConverter(C context);
}
