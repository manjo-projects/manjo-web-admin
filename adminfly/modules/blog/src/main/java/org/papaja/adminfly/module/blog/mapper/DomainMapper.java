package org.papaja.adminfly.module.blog.mapper;

import org.papaja.adminfly.commons.mapper.AbstractMapper;
import org.papaja.adminfly.module.blog.dto.DomainDto;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper extends AbstractMapper<DomainDto, Domain> {

    @Override
    public void accept(DomainDto source, Domain target) {
        target.setName(source.getName().toUpperCase());
        target.setDomain(source.getDomain());
    }

    @Override
    public Domain get() {
        return new Domain();
    }

}
