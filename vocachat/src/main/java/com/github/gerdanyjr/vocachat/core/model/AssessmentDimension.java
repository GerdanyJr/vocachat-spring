package com.github.gerdanyjr.vocachat.core.model;

public class AssessmentDimension {
    private Long assessmentDimensionId;
    private AssessmentType assessmentType;
    private String dimensionName;

    public AssessmentDimension(Long assessmentDimensionId, AssessmentType assessmentType, String dimensionName) {
        this.assessmentDimensionId = assessmentDimensionId;
        this.assessmentType = assessmentType;
        this.dimensionName = dimensionName;
    }

    public Long getAssessmentDimensionId() {
        return assessmentDimensionId;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public String getDimensionName() {
        return dimensionName;
    }
}
