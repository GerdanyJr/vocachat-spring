package com.github.gerdanyjr.vocachat.infra.out.event.pub.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.event.pub.IDomainEventPublisher;
import com.github.gerdanyjr.vocachat.application.event.pub.assessmentAnswer.AssessmentAnswerCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class AssessmentAnswerCreatedEventPublisher implements IDomainEventPublisher<AssessmentAnswerCreatedEvent> {
    @Override
    public void publish(AssessmentAnswerCreatedEvent event) {

    }
}
