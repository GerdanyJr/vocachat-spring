package com.github.gerdanyjr.vocachat.core.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum AnswerState {
    PENDING(1, "Pending"),
    DONE(2, "Done"),
    FAILED(3, "Failed");

    private final Integer value;
    private final String description;
    private final static Map<Integer, AnswerState> mapValues = new HashMap<>();

    AnswerState(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    static {
        for (AnswerState state : AnswerState.values()) {
            mapValues.put(state.value, state);
        }
    }

    public static AnswerState fromValue(int value) {
        return mapValues.get(value);
    }
}
