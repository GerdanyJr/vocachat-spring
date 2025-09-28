package com.github.gerdanyjr.vocachat.application.usecase.assessment;

import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.core.enums.AssesmentState;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.AssessmentNotFoundException;
import com.github.gerdanyjr.vocachat.core.exception.impl.assessment.MinimumAnswersNotMetException;
import com.github.gerdanyjr.vocachat.core.model.Assessment;

public class FinishAssessmentUseCase {
    private final IAssessmentRepository assessmentRepository;

    public FinishAssessmentUseCase(IAssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    public void execute(Long assessmentId) {
        Assessment foundAssessment = assessmentRepository
                .findById(assessmentId)
                .orElseThrow(AssessmentNotFoundException::new);

        validateAssessment(foundAssessment);

        foundAssessment.finish();
        assessmentRepository.update(foundAssessment);
    }

    private void validateAssessment(Assessment assessment) {
        if (assessment.getAnswers().size() < 5) {
            throw new MinimumAnswersNotMetException();
        }
        if (assessment.getAssesmentState() != AssesmentState.IN_PROGRESS) {
            throw new RuntimeException("Assessment state is not in IN_PROGRESS");
        }
    }
}
