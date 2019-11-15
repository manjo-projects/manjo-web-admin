package org.papaja.adminfly.module.psy.commons.holder;

import org.papaja.adminfly.module.psy.dbl.entity.Patient;
import org.papaja.adminfly.module.psy.dbl.entity.Session;

import static java.lang.ThreadLocal.withInitial;

public enum TestContextHolder {
    INSTANCE;

    private static final ThreadLocal<Context> CONTEXT = withInitial(() -> new Context());

    public static class Context {

        private Patient patient = new Patient();
        private Session session = new Session();

        public Patient getPatient() {
            return patient;
        }

        public void setPatient(Patient patient) {
            this.patient = patient;
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
