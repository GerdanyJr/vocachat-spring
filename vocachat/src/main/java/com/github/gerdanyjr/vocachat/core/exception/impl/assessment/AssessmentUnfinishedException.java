package com.github.gerdanyjr.vocachat.core.exception.impl.assessment;

import com.github.gerdanyjr.vocachat.core.exception.base.UnprocessableEntityException;

public class AssessmentUnfinishedException extends UnprocessableEntityException {
    public AssessmentUnfinishedException() {
        super("Assessment not finished!");
    }
}
