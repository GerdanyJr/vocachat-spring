package com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.repository.assessmentAnswer.IAssessmentAnswerRepository;
import com.github.gerdanyjr.vocachat.core.model.AssessmentAnswer;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentAnswerEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessmentAnswer.IMapstructAssessmentAnswerMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessmentAnswerRepository.IAssessmentAnswerRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class AssessmentAnswerRepositoryImpl implements IAssessmentAnswerRepository {
    private final IAssessmentAnswerRepositoryJPA assessmentAnswerRepository;
    private final IMapstructAssessmentAnswerMapper mapper;

    @Override
    public AssessmentAnswer create(AssessmentAnswer assessmentAnswer) {
        AssessmentAnswerEntity createdAssessment = assessmentAnswerRepository
                .save(mapper.fromModelToEntity(assessmentAnswer));
        return mapper.fromEntityToModel(createdAssessment);
    }

    @Override
    public Optional<AssessmentAnswer> findById(Long assessmentAnswerId) {
        AssessmentAnswerEntity entity = assessmentAnswerRepository.findByAssessmentAnswerId(assessmentAnswerId);
        return Optional.ofNullable(mapper.fromEntityToModel(entity));
    }

    @Override
    public AssessmentAnswer update(AssessmentAnswer assessmentAnswer) {
        AssessmentAnswerEntity createdAssessment = assessmentAnswerRepository
                .save(mapper.fromModelToEntity(assessmentAnswer));
        return mapper.fromEntityToModel(createdAssessment);
    }
}
