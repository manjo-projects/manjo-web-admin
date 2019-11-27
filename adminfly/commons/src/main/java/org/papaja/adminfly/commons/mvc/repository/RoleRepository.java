package org.papaja.adminfly.commons.mvc.repository;

import org.papaja.adminfly.commons.mvc.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository extends AbstractRepository<Role> {

    public List<Role> getRoles() {
        return getList();
    }

    public List<Role> getRoles(List<Integer> ids) {
        return getList(ids);
    }

    public Role getRole(Integer id) {
        return get(id);
    }

    @Override
    public Class<Role> getReflection() {
        return Role.class;
    }
}
