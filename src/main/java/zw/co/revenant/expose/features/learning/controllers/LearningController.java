package zw.co.revenant.expose.features.learning.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.revenant.expose.features.learning.services.interfaces.LearningService;
import zw.co.revenant.expose.utils.models.ExposeResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/learn")
public class LearningController {

    private final LearningService learningService;

    @GetMapping("/")
    public ResponseEntity<ExposeResponse> getLearningArticles(){
        return learningService.getArticles();
    }
}
