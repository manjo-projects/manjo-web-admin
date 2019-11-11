package org.papaja.adminfly.module.psy.commons.crypto;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public enum CryptoUtils {

    INSTANCE("InnaPsy", "404136e388d8dfe2");

    private TextEncryptor encryptor;

    CryptoUtils(String password, String salt) {
        encryptor = Encryptors.text(password, salt);
    }

    public String encrypt(String value) {
        return encryptor.encrypt(value);
    }

    public String decrypt(String value) {
        return encryptor.decrypt(value);
    }

}
