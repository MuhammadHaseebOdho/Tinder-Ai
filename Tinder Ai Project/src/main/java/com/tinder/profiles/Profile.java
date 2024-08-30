package com.tinder.profiles;

public record Profile(
        String id,
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        String bio,
        String imageUrl,
        Gender gender,
        String myersBriggsPersonalityType


) {
}
