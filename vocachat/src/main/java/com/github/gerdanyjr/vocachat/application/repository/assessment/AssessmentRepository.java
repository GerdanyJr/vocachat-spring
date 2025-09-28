package com.github.gerdanyjr.vocachat.application.repository.assessment;

import com.github.gerdanyjr.vocachat.core.model.Assessment;

import java.util.Optional;

public interface AssessmentRepository {
    Assessment create(Assessment assessment);

    Optional<Assessment> findByUserId(Long userId);

    Optional<Assessment> findById(Long assessmentId);
}
