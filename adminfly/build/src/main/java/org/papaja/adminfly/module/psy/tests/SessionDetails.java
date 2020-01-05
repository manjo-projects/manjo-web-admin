package org.papaja.adminfly.module.psy.tests;

public interface SessionDetails {
    String getSessionId();

    boolean isActive();

    void setActive(boolean active);
}
