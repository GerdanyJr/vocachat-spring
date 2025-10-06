package com.github.gerdanyjr.vocachat.infra.out.repository.jpa.message;

import com.github.gerdanyjr.vocachat.infra.out.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepositoryJPA extends JpaRepository<MessageEntity, Long> {
}
