package com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessment;

import com.github.gerdanyjr.vocachat.application.repository.assessment.IAssessmentRepository;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessment.IMapstructAssessmentMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessment.IAssessmentRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AssessmentRepositoryImpl implements IAssessmentRepository {
    private final IMapstructAssessmentMapper assessmentMapper;
    private final IAssessmentRepositoryJPA assessmentRepositoryJpa;

    @Override
    public Assessment create(Assessment assessment) {
        AssessmentEntity entity = assessmentRepositoryJpa.save(assessmentMapper.fromModelToEntity(assessment));
        return assessmentMapper.fromEntityToModel(entity);
    }

    @Override
    public Optional<Assessment> findByUserId(Long userId) {
        AssessmentEntity assessment = assessmentRepositoryJpa.findByUserId(userId);
        return Optional.ofNullable(assessmentMapper.fromEntityToModel(assessment));
    }

    @Override
    public Optional<Assessment> findById(Long assessmentId) {
        AssessmentEntity assessment = assessmentRepositoryJpa.findByAssessmentId(assessmentId);
        return Optional.ofNullable(assessmentMapper.fromEntityToModel(assessment));
    }

    @Override
    public void update(Assessment assessment) {
        AssessmentEntity assessmentEntity = assessmentMapper.fromModelToEntity(assessment);
        assessmentRepositoryJpa.save(assessmentEntity);
    }
}
