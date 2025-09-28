package com.github.gerdanyjr.vocachat.application.event;

import java.time.LocalDateTime;

public interface IDomainEvent {
    String getName();

    LocalDateTime getOccurredAt();
}
