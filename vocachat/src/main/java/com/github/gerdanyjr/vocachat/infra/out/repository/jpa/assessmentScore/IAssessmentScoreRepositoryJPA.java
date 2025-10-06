package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessmentScore;

import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAssessmentScoreRepositoryJPA extends JpaRepository<AssessmentScoreEntity, Long> {
}
