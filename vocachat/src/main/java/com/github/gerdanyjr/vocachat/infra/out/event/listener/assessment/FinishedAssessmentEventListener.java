package com.github.gerdanyjr.vocachat.infra.out.event.listener.assessment;

import com.github.gerdanyjr.vocachat.application.event.pub.assessment.AssessmentFinishedEvent;
import com.github.gerdanyjr.vocachat.application.usecase.assessmentScore.CalculateAssessmentScoreUseCase;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FinishedAssessmentEventListener {
    private final CalculateAssessmentScoreUseCase calculateAssessmentScoreUseCase;

    @EventListener
    public void handleAssessmentFinished(AssessmentFinishedEvent event) {
        calculateAssessmentScoreUseCase.execute(event.getAssessmentId());
    }
}
