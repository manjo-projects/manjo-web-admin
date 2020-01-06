package org.papaja.adminfly.module.psy.tests.processing;

public interface Process<Input, Output> {
    Output proceed(Input input);
}
