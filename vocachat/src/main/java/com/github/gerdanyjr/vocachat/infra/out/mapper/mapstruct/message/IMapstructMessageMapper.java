package com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.message;

import com.github.gerdanyjr.vocachat.core.model.Message;
import com.github.gerdanyjr.vocachat.infra.out.entity.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapstructMessageMapper {
    MessageEntity fromModelToEntity(Message message);

    Message fromEntityToModel(MessageEntity entity);
}
