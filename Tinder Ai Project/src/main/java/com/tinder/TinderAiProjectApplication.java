package com.tinder;

import com.tinder.conversation.ChatMessages;
import com.tinder.conversation.Conversation;
import com.tinder.conversation.ConversationRepository;
import com.tinder.profiles.Gender;
import com.tinder.profiles.Profile;
import com.tinder.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class TinderAiProjectApplication implements CommandLineRunner {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ConversationRepository conversationRepository;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiProjectApplication.class, args);
    }

    public void run(String... args){
        System.out.println("Command Line Runner");
        Profile profile=new Profile(
                "1",
                "Test",
                "Testoo",
                23,
                "Muslim",
                "Love Cricket",
                "cric.jpg",
                Gender.MALE
        );

        profileRepository.save(profile);
        profileRepository.findAll().forEach(System.out::println);


        Conversation conversation=new Conversation(
                "1",
                profile.id(),
               List.of( new ChatMessages(
                       "Hello",
                       profile.id(),
                       LocalDateTime.now()
               ))
        );
        conversationRepository.save(conversation);
        conversationRepository.findAll().forEach(System.out::println);
    }


}
