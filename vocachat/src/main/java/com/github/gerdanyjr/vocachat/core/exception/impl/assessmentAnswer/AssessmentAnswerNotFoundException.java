package com.github.gerdanyjr.vocachat.core.exception.impl.assessmentAnswer;

import com.github.gerdanyjr.vocachat.core.exception.base.NotFoundException;

public class AssessmentAnswerNotFoundException extends NotFoundException {
    public AssessmentAnswerNotFoundException() {
        super("Assessment not found!");
    }
}
