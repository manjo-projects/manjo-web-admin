package org.papaja.adminfly.module.psy.dbl.dto;

import org.papaja.adminfly.module.psy.tests.Test;

import javax.validation.constraints.NotBlank;

public class SessionDto {

    @NotBlank(message = "{validation.notBlank}")
    private String test;

    public Test getTest() {
        return Test.valueOf(test);
    }

    public void setTest(String test) {
        this.test = test;
    }

}
