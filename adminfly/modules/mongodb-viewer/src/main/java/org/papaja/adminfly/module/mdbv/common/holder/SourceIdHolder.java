package org.papaja.adminfly.module.mdbv.common.holder;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.function.Supplier;

public class SourceIdHolder implements Supplier<Integer> {

    @Autowired
    private HttpSession session;

    private String sessionKey;

    public SourceIdHolder(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public Integer get() {
        return (Integer) session.getAttribute(sessionKey);
    }

    public void set(Integer value) {
        session.setAttribute(sessionKey, value);
    }

}
