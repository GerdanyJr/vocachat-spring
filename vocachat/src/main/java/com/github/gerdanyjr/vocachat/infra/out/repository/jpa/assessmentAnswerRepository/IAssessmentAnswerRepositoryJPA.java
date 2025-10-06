package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessmentAnswerRepository;

import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssessmentAnswerRepositoryJPA extends JpaRepository<AssessmentAnswerEntity, Long> {
    AssessmentAnswerEntity findByAssessmentAnswerId(Long assessmentAnswerId);
}
