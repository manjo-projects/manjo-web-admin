package org.papaja.adminfly.commons.mvc.entity;

import org.papaja.adminfly.commons.mvc.entity.api.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "SECURITY_ROLES")
public class Role extends AbstractEntity {

    @Size(min = 5, max = 16)
    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "SECURITY_USERS_ROLES",
        joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    )
    private Collection<User> users;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "SECURITY_ROLES_PRIVILEGES",
        joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "ID")
    )
    private Collection<Privilege> privileges;

    public Role() {
        this(null);
    }

    public Role(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public List<Integer> getPrivilegesIds() {
        return privileges.stream().map(Privilege::getId).collect(Collectors.toList());
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return String.format("Role{id=%d, name='%s', privileges=%s}", id, name, privileges);
    }
}
