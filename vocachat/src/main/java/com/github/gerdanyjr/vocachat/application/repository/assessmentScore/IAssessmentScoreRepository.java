package com.github.gerdanyjr.vocachat.application.repository.assessmentScore;

import com.github.gerdanyjr.vocachat.core.model.AssessmentScore;

import java.util.List;

public interface IAssessmentScoreRepository {
    List<AssessmentScore> createAll(List<AssessmentScore> assessmentScores);
}
