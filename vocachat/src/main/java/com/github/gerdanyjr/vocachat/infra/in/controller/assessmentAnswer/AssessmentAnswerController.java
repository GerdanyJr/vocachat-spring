package com.github.gerdanyjr.vocachat.infra.in.controller.assessmentAnswer;

import com.github.gerdanyjr.vocachat.application.dto.in.assessmentAnswer.CreateAssessmentAnswerRequest;
import com.github.gerdanyjr.vocachat.application.usecase.assessmentAnswer.CreateAssessmentAnswerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/assessment-answer")
public class AssessmentAnswerController {
    private final CreateAssessmentAnswerUseCase createAssessmentAnswerUseCase;

    public AssessmentAnswerController(CreateAssessmentAnswerUseCase createAssessmentAnswerUseCase) {
        this.createAssessmentAnswerUseCase = createAssessmentAnswerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> createAssessmentAnswer(
            @RequestBody CreateAssessmentAnswerRequest assessmentAnswerRequest
    ) {
        createAssessmentAnswerUseCase.execute(assessmentAnswerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
