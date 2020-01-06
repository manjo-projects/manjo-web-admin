package org.papaja.adminfly.module.psy.tests.processing;

abstract public class AbstractChain<V> implements Chain<V> {

    private Chain next;

    @Override
    public void with(Chain next) {
        this.next = next;
    }

    @Override
    public boolean next(V value) {
        boolean result = false;

        if (next != null) {
            result = next.process(value);
        }

        return result;
    }

}
