package com.github.gerdanyjr.vocachat.infra.in.controller.assessment;

import com.github.gerdanyjr.vocachat.application.dto.in.assessment.CreateAssessmentRequest;
import com.github.gerdanyjr.vocachat.application.dto.out.assessment.AssessmentResponse;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.CreateAssessmentUseCase;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.FindAssessmentByUserIdUseCase;
import com.github.gerdanyjr.vocachat.application.usecase.assessment.FinishAssessmentUseCase;
import com.github.gerdanyjr.vocachat.core.model.Assessment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/assessments")
public class AssessmentController {
    private final CreateAssessmentUseCase createAssessmentUseCase;
    private final FindAssessmentByUserIdUseCase findAssessmentByUserIdUseCase;
    private final FinishAssessmentUseCase finishAssessmentUseCase;

    public AssessmentController(
            CreateAssessmentUseCase createAssessmentUseCase,
            FindAssessmentByUserIdUseCase findAssessmentByUserIdUseCase,
            FinishAssessmentUseCase finishAssessmentUseCase
    ) {
        this.createAssessmentUseCase = createAssessmentUseCase;
        this.findAssessmentByUserIdUseCase = findAssessmentByUserIdUseCase;
        this.finishAssessmentUseCase = finishAssessmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createAssessment(@RequestBody CreateAssessmentRequest createAssessmentRequest) {
        Assessment createdAssessment = createAssessmentUseCase.execute(createAssessmentRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/user/{userId}")
                .buildAndExpand(createdAssessment.getUser().getUserId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AssessmentResponse> findAssessmentByUserId(@PathVariable Long userId) {
        AssessmentResponse foundAssessment = findAssessmentByUserIdUseCase.execute(userId);

        return ResponseEntity.ok(foundAssessment);
    }

    @PatchMapping("/{assessmentId}/finish")
    public ResponseEntity<Void> finishAssessment(@PathVariable Long assessmentId) {
        finishAssessmentUseCase.execute(assessmentId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
