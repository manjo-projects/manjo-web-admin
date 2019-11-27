package org.papaja.adminfly.commons.mvc.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.papaja.adminfly.commons.mvc.entity.api.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@SuppressWarnings({"unused"})
@DynamicUpdate
@Entity
@Table(name = "SECURITY_USERS")
public class User extends AbstractEntity {

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED", columnDefinition = "TINYINT(1)")
    private Boolean enabled;

    @Column(name = "EXPIRED")
    private Timestamp expired;

    @Column(name = "CREATED")
    private Timestamp created;

    @Column(name = "UPDATED")
    private Timestamp updated;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(
        name = "SECURITY_USERS_ROLES",
        joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private Collection<Role> roles;

    public User() {
        roles = new ArrayList<>();
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Timestamp getExpired() {
        return expired;
    }

    public void setExpired(Timestamp expired) {
        this.expired = expired;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public Collection<Integer> getRolesIds() {
        return getRoles().stream().map(Role::getId).collect(Collectors.toList());
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public void addRole(Integer id) {
        if (nonNull(id)) {
            addRole(new Role(id));
        }
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, username='%s', enabled='%s', roles=%s}", id, username, enabled, roles);
    }
}
