package zw.co.revenant.expose.features.learning.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.revenant.expose.features.articles.models.requests.PostArticleRequest;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;
import zw.co.revenant.expose.features.auth.repositories.JournalistRepository;
import zw.co.revenant.expose.features.learning.models.dto.LearningArticleDto;
import zw.co.revenant.expose.features.learning.models.entities.LearningArticle;
import zw.co.revenant.expose.features.learning.repositories.LearningArticleRepository;
import zw.co.revenant.expose.features.learning.services.interfaces.LearningService;
import zw.co.revenant.expose.utils.DtoMapper;
import zw.co.revenant.expose.utils.models.ExposeResponse;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LearningServiceImpl implements LearningService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LearningServiceImpl.class);

    private final DtoMapper dtoMapper;

    private final LearningArticleRepository learningArticleRepository;
    private final JournalistRepository journalistRepository;

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

    @Override
    public ResponseEntity<ExposeResponse> postLearningArticle(PostArticleRequest request) {
        try {

            if (request.getArticleTitle() == null || request.getArticleBody() == null || request.getJournalistCode() == null) {
                return new ResponseEntity<>(new ExposeResponse("Request fields are required"), HttpStatus.BAD_REQUEST);
            }

            Optional<Journalist> journalist = journalistRepository.findByJournalistCode(request.getJournalistCode());

            if (journalist.isPresent()) {
                LearningArticle article = LearningArticle
                        .builder()
                        .articleCode(UUID.randomUUID().toString())
                        .body(request.getArticleBody())
                        .title(request.getArticleTitle())
                        .createdOn(new Date())
                        .journalist(journalist.get())
                        .build();

                learningArticleRepository.save(article);

                return new ResponseEntity<>(new ExposeResponse("Article Created Successfully"), HttpStatus.CREATED);
            }

            return new ResponseEntity<>(new ExposeResponse("Journalist not found"), HttpStatus.NOT_FOUND);


        } catch (Exception e) {
            LOGGER.error("Post Learning article error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
