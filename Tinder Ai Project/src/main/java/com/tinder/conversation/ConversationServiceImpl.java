package com.tinder.conversation;

import com.tinder.profiles.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class ConversationServiceImpl implements ConversationService{

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Conversation createNewConversation(RequestProfile requestProfile) {
        conversationRepository.findById(requestProfile.requestProfileId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requested Conversation Id"
                                + requestProfile.requestProfileId()+
                                " is not found"
                ));

        Conversation conversation=new Conversation(
                UUID.randomUUID().toString(),
                requestProfile.requestProfileId(),
                new ArrayList<>()
        );
        return conversationRepository.save(conversation);
    }

    @Override
    public Conversation addNewMessage(String conversationId, ChatMessages chatMessages) {
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requested Conversation Id"
                                + conversationId +
                                " is not found"
                ));

        profileRepository.findById(chatMessages.authorId())
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Requested Conversation Id"
                                        + chatMessages.authorId() +
                                        " is not found"
                        ));

        ChatMessages chatMessagesWithTime= new ChatMessages(
                chatMessages.messageText(),
                chatMessages.authorId(),
                LocalDateTime.now()
        );

        conversation.chatMessages().add(chatMessagesWithTime);

        return conversationRepository.save(conversation);
    }


    @Override
    public Conversation getConversation(String conversationId) {

        return conversationRepository.findById(conversationId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requested Conversation Id"
                                + conversationId +
                                " is not found"
                ));
    }
}
