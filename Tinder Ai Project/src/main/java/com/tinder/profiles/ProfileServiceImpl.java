package com.tinder.profiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Profile getRandomProfile() {
        return profileRepository.getRandomProfile();
    }
}
