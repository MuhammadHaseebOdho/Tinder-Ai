package com.tinder.conversation;

public interface ConversationService {

     Conversation createNewConversation(RequestProfile requestProfile);

     Conversation addNewMessage(String conversationId,ChatMessages chatMessages);

     Conversation getConversation(String conversationId);

}
