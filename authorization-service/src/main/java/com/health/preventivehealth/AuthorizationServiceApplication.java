package com.health.preventivehealth;

import com.health.preventivehealth.model.Role;
import com.health.preventivehealth.model.User;
import com.health.preventivehealth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class AuthorizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner registerUser(UserRepository repository){
        return args -> {
            repository.save(new User("user", passwordEncoder().encode("password"), Arrays.asList(new Role("ADMIN"))));
        };
    }

}
