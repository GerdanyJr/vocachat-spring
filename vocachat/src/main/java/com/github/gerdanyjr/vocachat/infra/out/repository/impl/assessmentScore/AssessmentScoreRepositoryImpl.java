package com.github.gerdanyjr.vocachat.infra.out.repository.impl.assessmentScore;

import com.github.gerdanyjr.vocachat.application.repository.assessmentScore.IAssessmentScoreRepository;
import com.github.gerdanyjr.vocachat.core.model.AssessmentScore;
import com.github.gerdanyjr.vocachat.infra.out.entity.AssessmentScoreEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.assessmentScore.IMapstructAssessmentScoreMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.assessmentScore.IAssessmentScoreRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class AssessmentScoreRepositoryImpl implements IAssessmentScoreRepository {
    private final IAssessmentScoreRepositoryJPA assessmentScoreRepository;
    private final IMapstructAssessmentScoreMapper assessmentScoreMapper;

    @Override
    public List<AssessmentScore> createAll(List<AssessmentScore> assessmentScores) {
        List<AssessmentScoreEntity> entities = assessmentScores
                .stream()
                .map(assessmentScoreMapper::fromModelToEntity)
                .toList();

        return assessmentScoreRepository
                .saveAll(entities)
                .stream()
                .map(assessmentScoreMapper::fromEntityToModel)
                .toList();
    }
}
