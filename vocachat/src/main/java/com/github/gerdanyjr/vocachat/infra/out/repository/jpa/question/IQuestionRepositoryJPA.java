package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.question;

import com.github.gerdanyjr.vocachat.infra.out.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionRepositoryJPA extends JpaRepository<QuestionEntity, Long> {
    QuestionEntity findByQuestionId(Long questionId);
}
