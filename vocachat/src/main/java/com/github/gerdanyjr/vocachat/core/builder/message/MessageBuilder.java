package com.github.gerdanyjr.vocachat.core.builder.message;

import com.github.gerdanyjr.vocachat.core.enums.MessageSender;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.Message;

import java.time.LocalDateTime;

public class MessageBuilder {
    private Long messageId;
    private Assessment assessment;
    private String content;
    private LocalDateTime sentAt;
    private MessageSender sender;

    public Message build() {
        return new Message(messageId, assessment, content, sentAt, sender);
    }

    public MessageBuilder messageId(Long messageId) {
        this.messageId = messageId;
        return this;
    }

    public MessageBuilder assessment(Assessment assessment) {
        this.assessment = assessment;
        return this;
    }

    public MessageBuilder content(String content) {
        this.content = content;
        return this;
    }

    public MessageBuilder sentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    public MessageBuilder sender(MessageSender sender) {
        this.sender = sender;
        return this;
    }

}
