package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assessments")
public class AssessmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Long assessmentId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_type_id", nullable = false)
    private AssessmentTypeEntity assessmentTypeEntity;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "finished_at")
    private LocalDateTime finishedAt;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    @Column(name = "assessment_state", nullable = false)
    private Integer assessmentState;

    @OneToMany(mappedBy = "assessmentEntity")
    private List<AssessmentAnswerEntity> answers;

    @OneToMany(mappedBy = "assessmentEntity")
    private List<MessageEntity> messages;

    public Integer getAssessmentState() {
        return assessmentState;
    }

    public void setAssessmentState(Integer assessmentState) {
        this.assessmentState = assessmentState;
    }
}
