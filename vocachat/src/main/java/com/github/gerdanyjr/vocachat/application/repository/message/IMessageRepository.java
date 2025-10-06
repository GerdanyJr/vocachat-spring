package com.github.gerdanyjr.vocachat.application.repository.message;

import com.github.gerdanyjr.vocachat.core.model.Message;

public interface IMessageRepository {
    Message create(Message message);
}
