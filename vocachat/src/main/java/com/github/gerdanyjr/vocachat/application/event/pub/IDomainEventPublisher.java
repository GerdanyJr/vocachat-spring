package com.github.gerdanyjr.vocachat.application.event.pub;

import com.github.gerdanyjr.vocachat.application.event.IDomainEvent;

public interface IDomainEventPublisher<T extends IDomainEvent> {
    void publish(T event);
}
