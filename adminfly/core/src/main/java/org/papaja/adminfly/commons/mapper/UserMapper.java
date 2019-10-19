package org.papaja.adminfly.commons.mapper;

import org.papaja.adminfly.commons.dto.UserDto;
import org.papaja.adminfly.commons.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class UserMapper extends AbstractMapper<UserDto, User> {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void accept(UserDto source, User target) {
        if (target.isNew()) {
            target.setCreated(Timestamp.from(Instant.now()));
        }

        target.setUsername(source.getUsername());
        target.setEnabled(source.isEnabled());

        if (!source.getPassword().isEmpty()) {
            target.setPassword(encoder.encode(source.getPassword()));
        }

        if (target.isOld()) {
            target.setUpdated(Timestamp.from(Instant.now()));
        }
    }

    @Override
    public User get() {
        return new User();
    }

}
