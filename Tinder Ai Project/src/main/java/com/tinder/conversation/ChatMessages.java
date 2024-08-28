package com.tinder.conversation;

import java.time.LocalDateTime;

public record ChatMessages(
        String messageText,
        String authorId,
        LocalDateTime messageTime
) {
}
