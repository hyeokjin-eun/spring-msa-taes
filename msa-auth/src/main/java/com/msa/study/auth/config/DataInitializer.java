package com.msa.study.auth.config;

import com.msa.study.auth.domain.User;
import com.msa.study.auth.infra.UserDao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class DataInitializer implements ApplicationRunner {
    @Resource
    private UserDao userDao;

    @Override
    public void run(ApplicationArguments args) {
        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        userDao.save(User.builder()
                .userName("alvin")
                .password(passwordEncoder.encode("password"))
                .userType(0)
                .date(new Date())
                .build());
    }
}
