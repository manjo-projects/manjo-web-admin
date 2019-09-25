package org.papaja.adminfly.core.dto;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
