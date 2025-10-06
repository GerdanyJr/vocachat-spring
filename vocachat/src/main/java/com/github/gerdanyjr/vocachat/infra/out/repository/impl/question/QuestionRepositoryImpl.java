package com.github.gerdanyjr.vocachat.infra.out.repository.impl.question;

import com.github.gerdanyjr.vocachat.application.repository.question.IQuestionRepository;
import com.github.gerdanyjr.vocachat.core.model.Question;
import com.github.gerdanyjr.vocachat.infra.out.entity.QuestionEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.question.IMapstructQuestionMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.question.IQuestionRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class QuestionRepositoryImpl implements IQuestionRepository {
    private final IQuestionRepositoryJPA questionRepository;
    private final IMapstructQuestionMapper mapper;

    @Override
    public Optional<Question> findById(Long questionId) {
        QuestionEntity question = questionRepository.findByQuestionId(questionId);
        return Optional.ofNullable(mapper.fromEntityToModel(question));
    }
}
