package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "assessment_dimensions")
@NoArgsConstructor
@Getter
@Setter
public class AssessmentDimensionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer assessmentDimensionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_type_id")
    private AssessmentTypeEntity assessmentTypeEntity;

    @Column(name = "dimension_name")
    private String dimensionName;
}
