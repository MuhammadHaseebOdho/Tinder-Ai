package com.tinder.profiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public Profile getProfile(){
        return profileService.getRandomProfile();
    }
}
