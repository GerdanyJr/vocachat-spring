package com.github.gerdanyjr.vocachat.infra.out.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "assessment_types")
public class AssessmentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long assessmentTypeId;

    @Column(length = 50, nullable = false)
    private String name;
}
