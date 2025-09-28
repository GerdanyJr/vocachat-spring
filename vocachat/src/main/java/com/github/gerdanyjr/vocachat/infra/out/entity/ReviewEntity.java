package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @OneToOne
    @JoinColumn(name = "assesment_id")
    private AssessmentEntity assessmentEntity;

    @Column(name = "consistency", nullable = false)
    private BigDecimal consistency;

    @Column(name = "coherence", nullable = false)
    private BigDecimal coherence;

    @Column(name = "notes", nullable = false, length = 1000)
    private String notes;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
