package org.papaja.adminfly.module.psy.commons.chain;

public interface Chain<V> {

    void with(Chain next);

    boolean check(V... values);

    boolean next();

}
