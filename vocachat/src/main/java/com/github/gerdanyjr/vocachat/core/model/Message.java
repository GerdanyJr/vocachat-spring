package com.github.gerdanyjr.vocachat.core.model;

import com.github.gerdanyjr.vocachat.core.enums.MessageSender;

import java.time.LocalDateTime;

public class Message {
    private Long messageId;
    private Assessment assessment;
    private String content;
    private LocalDateTime sentAt;
    private MessageSender sender;

    public Message(Long messageId, Assessment assessment, String content, LocalDateTime sentAt, MessageSender sender) {
        this.messageId = messageId;
        this.assessment = assessment;
        this.content = content;
        this.sentAt = sentAt;
        this.sender = sender;
    }

    public Long getMessageId() {
        return messageId;
    }

    public Assessment getAssessmentId() {
        return assessment;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public MessageSender getSender() {
        return sender;
    }
}
