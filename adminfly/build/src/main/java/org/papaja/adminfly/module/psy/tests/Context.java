package org.papaja.adminfly.module.psy.tests;

import org.papaja.function.BiFunction;

import static java.lang.String.format;

public interface Context extends TestAware, GenderAware {

    BiFunction<RuntimeException, String, String> UNSUPPORTED_OPERATION_EXCEPTION
            = (context, method) -> new UnsupportedOperationException(
                    format("Unsupported context action '%s#%s'", context, method));

    void setTest(Test test);

    void setGender(Gender gender);

}
