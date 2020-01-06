package org.papaja.adminfly.module.psy.commons.function;

public interface Preparer<Input, Output> {
    Value<Output> prepare(Input input);
}
