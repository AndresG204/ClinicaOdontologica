package com.example.demo.service;

import com.example.demo.entities.AppUser;
import com.example.demo.entities.AppUsuarioRoles;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public  void run(ApplicationArguments args)throws Exception{
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String pass=passwordEncoder.encode("digital");
        String passAdmin=passwordEncoder.encode("soyadmin");

        userRepository.save(new AppUser("Andres","Andres","andres@gmail.com",pass, AppUsuarioRoles.ROLE_USER));
        userRepository.save(new AppUser("daniel","daniel","daniel@gmail.com",passAdmin,AppUsuarioRoles.ROLE_ADMIN));
    }
}
