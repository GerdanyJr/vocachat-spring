package com.github.gerdanyjr.vocachat.application.event.pub;

import com.github.gerdanyjr.vocachat.application.event.IDomainEvent;

public interface IDomainEventPublisher {
    void publish(IDomainEvent event);
}
