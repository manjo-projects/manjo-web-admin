package org.papaja.adminfly.commons.entity;

import org.papaja.adminfly.commons.entity.api.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "SECURITY_PRIVILEGES")
public class Privilege extends AbstractEntity {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 3, max = 64, message = "{validation.size}")
    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "SECURITY_ROLES_PRIVILEGES",
        joinColumns = @JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private Collection<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return String.format("Privilege{id=%d, name='%s'}", id, name);
    }
}
