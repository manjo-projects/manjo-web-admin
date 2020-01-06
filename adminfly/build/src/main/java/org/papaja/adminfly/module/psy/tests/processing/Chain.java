package org.papaja.adminfly.module.psy.tests.processing;

public interface Chain<V> {

    void with(Chain next);

    boolean process(V value);

    boolean next(V value);

}
