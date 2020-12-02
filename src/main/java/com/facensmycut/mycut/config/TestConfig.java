package com.facensmycut.mycut.config;

import com.facensmycut.mycut.entities.User;
import com.facensmycut.mycut.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Deam Winchester", "ddog@gmail.com", "5550001", "123456");
        User u2 = new User(null, "Sam Winchester", "sammy@gmail.com", "5550002", "123456");
        User u3 = new User(null,  "Castiel", "cas@gmail.com", "0000001", "god");
        User u4 = new User(null, "Crowley", "kingdevil@gmail.com", "000666", "hell");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
    }
}
