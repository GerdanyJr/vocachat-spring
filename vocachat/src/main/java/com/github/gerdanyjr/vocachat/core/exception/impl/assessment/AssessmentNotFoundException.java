package com.github.gerdanyjr.vocachat.core.exception.impl.assessment;

import com.github.gerdanyjr.vocachat.core.exception.base.NotFoundException;

public class AssessmentNotFoundException extends NotFoundException {
    public AssessmentNotFoundException() {
        super("Assessment not found!");
    }
}
