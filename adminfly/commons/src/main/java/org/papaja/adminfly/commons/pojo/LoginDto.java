package org.papaja.adminfly.commons.pojo;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
