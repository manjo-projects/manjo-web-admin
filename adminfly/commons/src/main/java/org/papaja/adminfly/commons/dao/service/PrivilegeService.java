package org.papaja.adminfly.commons.dao.service;

import org.papaja.adminfly.commons.dao.entity.Privilege;
import org.papaja.adminfly.commons.dao.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrivilegeService extends AbstractService<Privilege, PrivilegeRepository> {

    @Autowired
    private PrivilegeRepository repository;

    public List<Privilege> getPrivileges() {
        return getAll();
    }

    public List<Privilege> getPrivileges(List<Integer> ids) {
        return getAll(ids);
    }

    @Override
    public PrivilegeRepository getRepository() {
        return repository;
    }

    @Override
    public Privilege get() {
        return new Privilege();
    }

}
