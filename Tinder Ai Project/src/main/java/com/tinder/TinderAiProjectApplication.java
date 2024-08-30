package com.tinder;

import com.tinder.profiles.ProfileCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TinderAiProjectApplication implements CommandLineRunner {




    @Autowired
    ProfileCreationService profileCreationService;


    public static void main(String[] args) {
        SpringApplication.run(TinderAiProjectApplication.class, args);
    }

    public void run(String... args){
        profileCreationService.saveProfilesToDB();
    }


}
