package com.github.gerdanyjr.vocachat.core.enums;

import java.util.HashMap;
import java.util.Map;

public enum MessageSender {
    USER(1, "user"),
    SYSTEM(2, "system");

    private final Integer value;
    private final String description;
    private final static Map<Integer, MessageSender> mapValues = new HashMap<>();

    MessageSender(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    static {
        for (MessageSender state : MessageSender.values()) {
            mapValues.put(state.value, state);
        }
    }

    public static MessageSender fromValue(int value) {
        return mapValues.get(value);
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
