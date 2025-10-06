package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.question;

import com.github.gerdanyjr.vocachat.core.model.Question;
import com.github.gerdanyjr.vocachat.infra.out.entity.QuestionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapstructQuestionMapper {

    QuestionEntity fromModelToEntity(Question question);

    Question fromEntityToModel(QuestionEntity entity);
}
