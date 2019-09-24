package org.papaja.kv.service;

import org.papaja.kv.dto.KeyValueDto;
import org.papaja.kv.entity.KeyValue;
import org.papaja.kv.mapper.KVMapper;
import org.papaja.kv.reposirory.KVRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KVService extends AbstractService<KeyValue, KVRepository> {

    @Autowired
    private KVRepository repository;

    @Autowired
    private KVMapper mapper;

    public void save(KeyValueDto dto, KeyValue entity) {
        mapper.map(dto, entity);
        merge(entity);
    }

    @Override
    public KVRepository getRepository() {
        return repository;
    }

    @Override
    public KeyValue get() {
        return new KeyValue();
    }

}
