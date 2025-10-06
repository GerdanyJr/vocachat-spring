package com.github.gerdanyjr.vocachat.application.usecase.assessmentScore;

import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.application.repository.assessmentScore.IAssessmentScoreRepository;
import com.github.gerdanyjr.vocachat.core.builder.assessmentScore.AssessmentScoreBuilder;
import com.github.gerdanyjr.vocachat.core.enums.AssessmentState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentUnfinishedException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.core.model.AssessmentDimension;
import com.github.gerdanyjr.vocachat.core.model.AssessmentScore;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculateAssessmentScoreUseCase {
    private final IAssessmentScoreRepository assessmentScoreRepository;
    private final IAssessmentRepository assessmentRepository;

    public CalculateAssessmentScoreUseCase(
            IAssessmentScoreRepository assessmentScoreRepository,
            IAssessmentRepository assessmentRepository
    ) {
        this.assessmentScoreRepository = assessmentScoreRepository;
        this.assessmentRepository = assessmentRepository;
    }

    public void execute(Long assessmentId) {
        Assessment assessment = assessmentRepository
                .findById(assessmentId)
                .orElseThrow(AssessmentNotFoundException::new);

        if (assessment.getAssessmentState() != AssessmentState.FINISHED) {
            throw new AssessmentUnfinishedException();
        }

        List<AssessmentScore> scores = new ArrayList<>();
        Map<AssessmentDimension, List<AssessmentAnswer>> groupedByDimension = assessment
                .getAnswers()
                .stream()
                .collect(Collectors.groupingBy(answer -> answer.getQuestion().getDimension()));

        for (Map.Entry<AssessmentDimension, List<AssessmentAnswer>> entry : groupedByDimension.entrySet()) {
            AssessmentDimension dimension = entry.getKey();
            List<AssessmentAnswer> answersInDimension = entry.getValue();

            BigDecimal dimensionScore = answersInDimension.stream()
                    .map(AssessmentAnswer::getCompatibilityPercentage)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .divide(BigDecimal.valueOf(answersInDimension.size()), RoundingMode.HALF_UP);

            AssessmentScore score = new AssessmentScoreBuilder()
                    .assessment(assessment)
                    .dimension(dimension)
                    .score(dimensionScore)
                    .calculatedAt(LocalDateTime.now())
                    .build();

            scores.add(score);
        }

        assessment.process();
        assessmentScoreRepository.createAll(scores);
    }
}
