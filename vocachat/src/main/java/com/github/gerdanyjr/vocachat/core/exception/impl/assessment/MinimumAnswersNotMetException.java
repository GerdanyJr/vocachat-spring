package com.github.gerdanyjr.vocachat.core.exception.impl.assessment;

import com.github.gerdanyjr.vocachat.core.exception.base.BadRequestException;

public class MinimumAnswersNotMetException extends BadRequestException {
    public MinimumAnswersNotMetException() {
        super("Minimum answers is 5");
    }
}
