package org.papaja.mdbv.mysql.service;

import org.papaja.commons.structure.tuple.Pair;
import org.papaja.mdbv.mysql.dto.RowDto;
import org.papaja.mdbv.mysql.entity.Row;
import org.papaja.mdbv.mysql.mapper.RowMapper;
import org.papaja.mdbv.mysql.repository.RowRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class RowService extends AbstractService<Row, RowRepository> {

    @Autowired
    private RowRepository repository;

    @Autowired
    private SourceService sources;

    @Autowired
    private RowMapper mapper;

    public void save(RowDto dto, Row row) {
        mapper.map(dto, row);

        row.setPreview(dto.isPreview());
        row.setStatus(Row.Status.F);
        row.setSource(sources.getActiveSource());

        merge(row);
    }

    @Override
    public RowRepository getRepository() {
        return repository;
    }

    @Override
    public Row get() {
        return new Row();
    }

    public List<Row> getPreviewRows() {
        return repository.getList(repository.getConsumer(
            Arrays.asList(new Pair<>("source", sources.getActiveSource()), new Pair<>("preview", 1))
        ));
    }

    public List<Row> getRows() {
        return repository.getList(repository.getConsumer(Collections.singletonList(
                new Pair<>("source", sources.getActiveSource())
        )).after((builder, query, root) -> query.orderBy(builder.asc(root.get("status")))));
    }

    public List<Row> getSortedRows() {
        return repository.getList(repository.getConsumer(Arrays.asList(
                new Pair<>("source", sources.getActiveSource()),
                new Pair<>("status", Row.Status.F)
        )).after((builder, query, root) -> query.orderBy(builder.asc(root.get("position")))));
    }

}
