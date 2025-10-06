package com.github.gerdanyjr.vocachat.core.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum AssessmentState {
    CREATED(1, "Created"),
    PROCESSING(2, "Processing"),
    FINISHED(3, "Finished");

    private final Integer value;
    private final String description;
    private final static Map<Integer, AssessmentState> mapValues = new HashMap<>();

    AssessmentState(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    static {
        for (AssessmentState state : AssessmentState.values()) {
            mapValues.put(state.value, state);
        }
    }

    public static AssessmentState fromValue(int value) {
        return mapValues.get(value);
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
