package org.papaja.adminfly.module.kv.mapper;

import org.papaja.adminfly.commons.mvc.mapper.AbstractMapper;
import org.papaja.adminfly.module.kv.dto.KeyValueDto;
import org.papaja.adminfly.module.kv.entity.KeyValue;
import org.springframework.stereotype.Component;

@Component
public class KVMapper extends AbstractMapper<KeyValueDto, KeyValue> {

    @Override
    public void accept(KeyValueDto source, KeyValue target) {
        target.setKey(source.getKey().toUpperCase());
        target.setValue(source.getValue());
    }

    @Override
    public KeyValue get() {
        return new KeyValue();
    }

}
