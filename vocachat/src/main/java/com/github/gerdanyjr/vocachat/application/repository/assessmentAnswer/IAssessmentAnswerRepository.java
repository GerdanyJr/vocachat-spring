package com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer;

import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;

import java.util.Optional;

public interface IAssessmentAnswerRepository {
    AssessmentAnswer create(AssessmentAnswer assessmentAnswer);

    Optional<AssessmentAnswer> findById(Long assessmentAnswerId);

    AssessmentAnswer update(AssessmentAnswer assessmentAnswer);
}
