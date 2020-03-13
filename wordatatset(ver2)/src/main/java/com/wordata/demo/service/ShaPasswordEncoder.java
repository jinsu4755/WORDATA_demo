package com.wordata.demo.service;

import com.wordata.demo.utils.EncryptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShaPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        log.debug("ShaPasswordEncoder.encode :::: {}",rawPassword);
        return EncryptionUtils.encryptSHA256(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        log.debug("ShaPasswordEncoder.matches :::: {} <-> {}",rawPassword,encodedPassword);
        return EncryptionUtils.encryptSHA256(rawPassword.toString()).equals(encodedPassword);
    }
}
