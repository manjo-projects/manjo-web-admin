package org.papaja.adminfly.module.psy.tests;

import java.util.Map;

public interface Calculator<T, R> {

    R calculate(Map<Integer, T> results);

}
