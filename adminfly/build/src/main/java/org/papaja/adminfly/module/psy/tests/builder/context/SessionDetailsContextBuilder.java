package org.papaja.adminfly.module.psy.tests.builder.context;

import org.papaja.adminfly.module.psy.tests.context.PatientDetails;
import org.papaja.adminfly.module.psy.tests.context.SessionContext;
import org.papaja.adminfly.module.psy.tests.context.SessionDetails;
import org.papaja.adminfly.module.psy.tests.context.SessionDetailsContext;

public class SessionDetailsContextBuilder extends AbstractTestContextBuilder<SessionDetailsContextBuilder, SessionContext> {

    public SessionDetailsContextBuilder() {
        this.context = new SessionDetailsContext();
    }

    public SessionDetailsContextBuilder with(SessionDetails session) {
        context.setSession(session);

        return self();
    }

    public SessionDetailsContextBuilder with(PatientDetails patient) {
        context.setPatient(patient);

        return self();
    }

    @Override
    public SessionContext build() {
        return context;
    }

}
