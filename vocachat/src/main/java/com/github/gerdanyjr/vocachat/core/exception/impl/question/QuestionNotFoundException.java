package com.github.gerdanyjr.vocachat.core.exception.impl.question;

import com.github.gerdanyjr.vocachat.core.exception.base.NotFoundException;

public class QuestionNotFoundException extends NotFoundException {
    public QuestionNotFoundException() {
        super("Question not found!");
    }
}
