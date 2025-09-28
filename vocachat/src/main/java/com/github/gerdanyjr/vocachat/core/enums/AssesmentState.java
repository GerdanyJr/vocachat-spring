package com.github.gerdanyjr.vocachat.core.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum AssesmentState {
    IN_PROGRESS(1, "In Progress"),
    FINISHED(3, "Finished");

    private final Integer value;
    private final String description;
    private final static Map<Integer, AssesmentState> mapValues = new HashMap<>();

    AssesmentState(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    static {
        for (AssesmentState state : AssesmentState.values()) {
            mapValues.put(state.value, state);
        }
    }

    public static AssesmentState fromValue(int value) {
        return mapValues.get(value);
    }
}
