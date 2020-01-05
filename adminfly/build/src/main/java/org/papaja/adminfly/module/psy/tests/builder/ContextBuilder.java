package org.papaja.adminfly.module.psy.tests.builder;

import org.papaja.adminfly.module.psy.tests.*;
import org.papaja.adminfly.module.psy.tests.context.PrototypeContext;

public class ContextBuilder extends AbstractBuilder<ContextBuilder, Context> {

    private Context context;

    public ContextBuilder(Context context) {
        this.context = context;
    }

    public ContextBuilder() {
        this(new PrototypeContext());
    }

    public ContextBuilder withGender(Gender gender) {
        context.setGender(gender);

        return self();
    }

    public ContextBuilder withPayload(Payload payload) {
        context.setPayload(payload);

        return self();
    }

    public ContextBuilder withTest(Test test) {
        context.setTest(test);

        return self();
    }

    public ContextBuilder withSession(SessionDetails session) {
        context.setSession(session);

        return self();
    }

    public ContextBuilder withSession(PatientDetails patient) {
        context.setPatient(patient);

        return self();
    }

    @Override
    public Context build() {
        return context;
    }

}
