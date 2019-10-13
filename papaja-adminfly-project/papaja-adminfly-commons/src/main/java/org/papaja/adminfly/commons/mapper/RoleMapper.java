package org.papaja.adminfly.commons.mapper;

import org.papaja.adminfly.commons.dto.RoleDto;
import org.papaja.adminfly.commons.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends AbstractMapper<RoleDto, Role> {

    @Override
    public void accept(RoleDto source, Role target) {
        target.setName(source.getName().toUpperCase());
    }

    @Override
    public Role get() {
        return new Role();
    }

}
