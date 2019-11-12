package org.papaja.adminfly.module.blog.entity;

import org.papaja.adminfly.commons.entity.api.AbstractEntity;
import org.papaja.adminfly.commons.entity.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "BLOG_DOMAINS")
public class Domain extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DOMAIN")
    private String domain;

    @ManyToMany(cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "BLOG_USERS_DOMAINS",
        joinColumns = @JoinColumn(name = "DOMAIN_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    )
    private Collection<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Set<Integer> getUsersIds() {
        return users.stream().map(User::getId).collect(Collectors.toSet());
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Boolean hasUserAccess(User user) {
        return hasUserAccess(user.getId());
    }

    public Boolean hasUserAccess(Integer userId) {
        return getUsersIds().contains(userId);
    }

    @Override
    public String toString() {
        return String.format("Domain{name='%s', domain='%s'}", name, domain);
    }
}
