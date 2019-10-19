package org.papaja.adminfly.commons.dto;

import javax.validation.constraints.Size;
import java.util.List;

public class UserDto {

    private Integer id;

    @Size(min = 2, max = 64, message = "{validation.size}")
    private String username;

    private String password;

    private boolean enabled;

    private List<Integer> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format("UserDto{id=%d, username='%s', password='%s', enabled=%s, roles=%s}",
            id, username, password, enabled, roles);
    }
}
