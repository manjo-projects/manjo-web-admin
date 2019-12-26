package org.papaja.adminfly.module.psy.commons.holder;

import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;

import static java.lang.ThreadLocal.withInitial;

public enum TestContextHolder {
    INSTANCE;

    private static final ThreadLocal<Context> CONTEXT = withInitial(() -> new Context() {{
        setSession(new Session() {{
            setPatient(new Patient());
        }});
    }});

    public static class Context {

        private Session session;

        public Patient getPatient() {
            return session.getPatient();
        }

        public void setPatient(Patient patient) {
            this.session.setPatient(patient);
        }

        public Session getSession() {
            return session;
        }

        public void setSession(Session session) {
            this.session = session;
        }

    }

    public static Context getTestContext() {
        return INSTANCE.CONTEXT.get();
    }

}
