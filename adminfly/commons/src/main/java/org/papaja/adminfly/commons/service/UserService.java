package org.papaja.adminfly.commons.service;

import org.papaja.adminfly.commons.vendor.hibernate.Pagination;
import org.papaja.adminfly.commons.entity.User;
import org.papaja.adminfly.commons.mapper.UserMapper;
import org.papaja.adminfly.commons.dto.UserDto;
import org.papaja.adminfly.commons.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService extends AbstractService<User, UserRepository> {

    private static final int MAX_RESULT_PER_PAGE = 5;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleService roles;

    @Autowired
    private UserMapper mapper;

    public User loadUserByUsername(String username) {
        return repository.getUser(username);
    }

    public Pagination<User> getUsers(int offset) {
        return Pagination.of(getQuery(), offset, MAX_RESULT_PER_PAGE);
    }

    public List<User> getUsers() {
        return getAll();
    }

    public void save(UserDto dto, User entity) {
        mapper.map(dto, entity);

        if (entity.isOld()) {
            entity.setRoles(roles.getRoles(dto.getRoles()));
        }

        merge(entity);
    }

    public User getUser(Integer id) {
        return getOne(id);
    }

    @Override
    public UserRepository getRepository() {
        return repository;
    }

    @Override
    public User get() {
        return new User();
    }

}
