package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessment;

import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAssessmentRepositoryJPA extends JpaRepository<AssessmentEntity, Long> {
    @Query("SELECT A FROM AssessmentEntity A WHERE A.userEntity.userId = :userId")
    AssessmentEntity findByUserId(@Param("userId") Long userId);

    AssessmentEntity findByAssessmentId(Long assessmentId);
}
