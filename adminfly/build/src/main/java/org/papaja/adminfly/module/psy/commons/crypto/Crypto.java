package org.papaja.adminfly.module.psy.commons.crypto;

import org.springframework.security.crypto.encrypt.TextEncryptor;

import static org.springframework.security.crypto.encrypt.Encryptors.delux;

public enum Crypto implements TextEncryptor {

    INSTANCE("b18b00bs", "404136e388d8dfe2");

    private TextEncryptor encryptor;

    Crypto(String password, String salt) {
        encryptor = delux(password, salt);
    }

    public String encrypt(String value) {
        return encryptor.encrypt(value);
    }

    public String decrypt(String value) {
        return encryptor.decrypt(value);
    }

}
