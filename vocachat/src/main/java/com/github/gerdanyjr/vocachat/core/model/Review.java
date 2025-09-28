package com.github.gerdanyjr.vocachat.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Review {
    private Long reviewId;
    private Assessment assessment;
    private BigDecimal consistency;
    private BigDecimal coherence;
    private String notes;
    private LocalDateTime createdAt;

    public Review(
            Long reviewId,
            Assessment assessment,
            BigDecimal consistency,
            BigDecimal coherence,
            String notes,
            LocalDateTime createdAt
    ) {
        this.reviewId = reviewId;
        this.assessment = assessment;
        this.consistency = consistency;
        this.coherence = coherence;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public BigDecimal getConsistency() {
        return consistency;
    }

    public void setConsistency(BigDecimal consistency) {
        this.consistency = consistency;
    }

    public BigDecimal getCoherence() {
        return coherence;
    }

    public void setCoherence(BigDecimal coherence) {
        this.coherence = coherence;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
