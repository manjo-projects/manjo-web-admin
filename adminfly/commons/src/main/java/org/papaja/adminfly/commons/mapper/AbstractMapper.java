package org.papaja.adminfly.commons.mapper;

import org.papaja.function.Supplier;

import java.util.Optional;
import java.util.function.BiConsumer;

abstract public class AbstractMapper<I, O> implements BiConsumer<I, O>, Supplier<O> {

    public void map(I source, O target) {
        accept(source, Optional.ofNullable(target).orElseGet(this::get));
    }

}
