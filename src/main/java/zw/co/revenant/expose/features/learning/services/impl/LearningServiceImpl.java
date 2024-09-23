package zw.co.revenant.expose.features.learning.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.revenant.expose.features.learning.models.dto.LearningArticleDto;
import zw.co.revenant.expose.features.learning.repositories.LearningArticleRepository;
import zw.co.revenant.expose.features.learning.services.interfaces.LearningService;
import zw.co.revenant.expose.utils.DtoMapper;
import zw.co.revenant.expose.utils.models.ExposeResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningServiceImpl implements LearningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LearningServiceImpl.class);

    private final DtoMapper dtoMapper;

    private final LearningArticleRepository learningArticleRepository;

    @Override
    public ResponseEntity<ExposeResponse> getArticles() {
        try {
            List<LearningArticleDto> learningArticles = learningArticleRepository.findAll().stream().map(dtoMapper::mapToLearningArticleDto).toList();

            return new ResponseEntity<>(new ExposeResponse(learningArticles), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Learning articles error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
