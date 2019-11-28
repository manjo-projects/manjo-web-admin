package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.commons.dao.mapper.AbstractMapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.RowDto;
import org.papaja.converter.Format;
import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.springframework.stereotype.Component;

@Component
public class RowMapper extends AbstractMapper<RowDto, Row> {

    @Override
    public void accept(RowDto source, Row target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setPosition(source.getPosition());
        target.setType(Format.valueOf(source.getType()));
    }

    @Override
    public Row get() {
        return new Row();
    }
}
