package com.github.gerdanyjr.vocachat.infra.in.controller.assessment;

import com.github.gerdanyjr.vocachat.application.dto.in.assessment.CreateAssessmentRequest;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.CreateAssessmentUseCase;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/assessment")
public class AssessmentController {
    private final CreateAssessmentUseCase createAssessmentUseCase;

    public AssessmentController(CreateAssessmentUseCase createAssessmentUseCase) {
        this.createAssessmentUseCase = createAssessmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createAssessment(@RequestBody CreateAssessmentRequest createAssessmentRequest) {
        Assessment createdAssessment = createAssessmentUseCase.execute(createAssessmentRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAssessment.getAssesmentId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }
}
