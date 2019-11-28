package org.papaja.adminfly.commons.dao.service;

import org.hibernate.query.Query;
import org.papaja.adminfly.commons.dao.entity.api.Entity;
import org.papaja.adminfly.commons.dao.repository.AbstractRepository;
import org.papaja.function.Supplier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

@SuppressWarnings({"all"})
@Transactional
abstract public class AbstractService<E extends Entity, R extends AbstractRepository<E>> implements Supplier<E> {

    public void remove(Integer id) {
        remove(getOne(id));
    }

    public void remove(E entity) {
        getRepository().remove(entity);
    }

    public void merge(E entity) {
        getRepository().merge(entity);
    }

    public void saveOrUpdate(E entity) {
        getRepository().saveOrUpdate(entity);
    }

    public E getOne() {
        return getOne(null);
    }

    public E getOne(Integer id) {
        return nonNull(id) ? getRepository().get(id) : get();
    }

    public List<E> getAll() {
        return getRepository().getList();
    }

    public <T extends Number> List<E> getAll(T... ids) {
        return getAll(asList(ids));
    }

    public <T extends Number> List<E> getAll(List<T> ids) {
        return getRepository().getList(ids);
    }

    public Query<E> getQuery() {
        return getRepository().createQuery();
    }

    abstract public R getRepository();

}
