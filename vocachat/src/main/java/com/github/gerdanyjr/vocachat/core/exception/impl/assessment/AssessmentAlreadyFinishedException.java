package com.github.gerdanyjr.vocachat.core.exception.impl.assessment;

import com.github.gerdanyjr.vocachat.core.exception.base.BadRequestException;

public class AssessmentAlreadyFinishedException extends BadRequestException {
    public AssessmentAlreadyFinishedException() {
        super("Assessment state is not in IN_PROGRESS");
    }
}
