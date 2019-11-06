package org.papaja.adminfly.module.psy.commons.holder;

import org.papaja.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class PatientHolder implements Supplier<Integer> {

    private static final String PSY_CURRENT_PATIENT_ID = "PSY_CURRENT_PATIENT_ID";

    @Autowired
    private HttpSession session;

    @Override
    public Integer get() {
        return (Integer) session.getAttribute(PSY_CURRENT_PATIENT_ID);
    }

    public void set(Integer value) {
        session.setAttribute(PSY_CURRENT_PATIENT_ID, value);
    }

    public boolean has() {
        return get() != null;
    }

}
