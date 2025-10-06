package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "messages")
@Entity
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private AssessmentEntity assessmentEntity;

    private String content;

    private LocalDateTime sentAt;

    private String sender;
}
