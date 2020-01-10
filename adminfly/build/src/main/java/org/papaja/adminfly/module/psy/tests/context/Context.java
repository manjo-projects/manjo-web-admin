package org.papaja.adminfly.module.psy.tests.context;

import org.papaja.adminfly.module.psy.tests.Gender;
import org.papaja.adminfly.module.psy.tests.Test;
import org.papaja.adminfly.module.psy.tests.TestAware;
import org.papaja.function.BiFunction;

import static java.lang.String.format;

public interface Context extends TestAware, GenderAware {

    BiFunction<RuntimeException, String, String> UNSUPPORTED_OPERATION_EXCEPTION
            = (context, method) -> new UnsupportedOperationException(
                    format("Unsupported context action '%s#%s'", context, method));

    void setTest(Test test);

    void setGender(Gender gender);

    default boolean hasTest() {
        return getTest() != null;
    }

    default boolean hasGender() {
        return getGender() != null;
    }

}
