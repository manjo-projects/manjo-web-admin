package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.commons.dao.mapper.AbstractMapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourceDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.springframework.stereotype.Component;

@Component
public class SourceMapper extends AbstractMapper<SourceDto, Source> {

    @Override
    public void accept(SourceDto source, Source target) {
        target.setName(source.getName());
        target.setCollection(source.getCollection());
        target.setDatabase(source.getDatabase());
    }

    @Override
    public Source get() {
        return new Source();
    }

}
