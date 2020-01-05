package org.papaja.adminfly.module.psy.tests;

public interface SessionDetails {

    String getSessionId();

    void setSessionId(String id);

    boolean isActive();

    void setActive(boolean active);

}
