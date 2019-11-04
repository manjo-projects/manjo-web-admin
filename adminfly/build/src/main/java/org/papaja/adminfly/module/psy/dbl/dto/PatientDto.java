package org.papaja.adminfly.module.psy.dbl.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static javax.validation.constraints.Pattern.Flag.UNICODE_CASE;

public class PatientDto {

    private Integer id;

    @Size(min = 2, max = 64, message = "{validation.size}")
    @Pattern(regexp = "^[\\p{L}]+$", message = "{validation.regex}", flags = UNICODE_CASE)
    private String name;

    @Size(min = 2, max = 64, message = "{validation.size}")
    @Pattern(regexp = "^[\\p{L}]+$", message = "{validation.regex}", flags = UNICODE_CASE)
    private String surname;

    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
