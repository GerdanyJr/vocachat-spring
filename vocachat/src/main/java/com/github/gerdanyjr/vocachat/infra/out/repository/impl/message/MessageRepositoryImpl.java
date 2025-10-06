package com.github.gerdanyjr.vocachat.infra.out.repository.impl.message;

import com.github.gerdanyjr.vocachat.application.repository.message.IMessageRepository;
import com.github.gerdanyjr.vocachat.core.model.Message;
import com.github.gerdanyjr.vocachat.infra.out.entity.MessageEntity;
import com.github.gerdanyjr.vocachat.infra.out.mapper.mapstruct.message.IMapstructMessageMapper;
import com.github.gerdanyjr.vocachat.infra.out.repository.jpa.message.IMessageRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MessageRepositoryImpl implements IMessageRepository {
    private final IMessageRepositoryJPA messageRepository;
    private final IMapstructMessageMapper mapper;

    @Override
    public Message create(Message message) {
        MessageEntity messageEntity = mapper.fromModelToEntity(message);

        return mapper.fromEntityToModel(messageRepository.save(messageEntity));
    }
}
