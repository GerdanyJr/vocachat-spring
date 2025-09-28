package com.github.gerdanyjr.vocachat.application.repository.question;

import com.github.gerdanyjr.vocachat.core.model.Question;

import java.util.Optional;

public interface IQuestionRepository {
    Optional<Question> findById(Long questionId);
}
