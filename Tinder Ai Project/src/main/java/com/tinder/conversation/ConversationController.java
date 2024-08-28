package com.tinder.conversation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConversationController {

    @Autowired
    ConversationService conversationService;


    @PostMapping("/conversations")
    public Conversation createNewConversation(@RequestBody RequestProfile requestProfile){
        return conversationService.createNewConversation(requestProfile);
    }

    @PostMapping("/conversation/{conversationId}")
    public Conversation addNewMessage(@PathVariable String conversationId,
                                      @RequestBody ChatMessages chatMessages){

        return conversationService.addNewMessage(conversationId, chatMessages);
    }

    @GetMapping("/conversation/{conversationId}")
    public Conversation getConversation(@PathVariable String conversationId){
        return conversationService.getConversation(conversationId);
    }


}
