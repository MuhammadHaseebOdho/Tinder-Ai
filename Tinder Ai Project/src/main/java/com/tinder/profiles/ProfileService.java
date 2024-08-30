package com.tinder.profiles;

import org.springframework.data.mongodb.repository.Aggregation;

public interface ProfileService {


    Profile getRandomProfile();
}
