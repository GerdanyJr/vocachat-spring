package com.github.gerdanyjr.vocachat.infra.out.event.pub.assessment;

import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessment.AssessmentFinishedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FinishedAssessmentEventPublisher implements IDomainEventPublisher<AssessmentFinishedEvent> {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(AssessmentFinishedEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
