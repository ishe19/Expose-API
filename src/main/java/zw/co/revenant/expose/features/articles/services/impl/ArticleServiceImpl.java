package zw.co.revenant.expose.features.articles.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;
import zw.co.revenant.expose.features.articles.models.requests.PostArticleRequest;
import zw.co.revenant.expose.features.articles.repositories.ArticleMediaRepository;
import zw.co.revenant.expose.features.articles.repositories.ArticleRepository;
import zw.co.revenant.expose.features.articles.services.interfaces.ArticleService;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;
import zw.co.revenant.expose.features.auth.repositories.JournalistRepository;
import zw.co.revenant.expose.utils.DtoMapper;
import zw.co.revenant.expose.utils.models.ExposeResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);


    private final ArticleRepository articleRepository;
    private final ArticleMediaRepository articleMediaRepository;
    private final JournalistRepository journalistRepository;

    private final DtoMapper dtoMapper;


    @Override
    public ResponseEntity<ExposeResponse> getArticles() {
        try {
            List<ArticleDto> articleDtos = articleRepository.findAll().stream().map(dtoMapper::mapToArticleDto).toList();
            return new ResponseEntity<>(new ExposeResponse(articleDtos), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("FAILED TO FETCH ARTICLES: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ExposeResponse> postArticle(PostArticleRequest request) {
        if (request.getArticleTitle() == null || request.getArticleSubtitle() == null || request.getArticleBody() == null || request.getJournalistCode() == null) {
            return new ResponseEntity<>(new ExposeResponse("Request fields are required"), HttpStatus.BAD_REQUEST);
        }

        try {
            Optional<Journalist> journalist = journalistRepository.findByJournalistCode(request.getJournalistCode());

            if (journalist.isPresent()) {
                Article article = Article
                        .builder()
                        .articleCode(UUID.randomUUID().toString())
                        .body(request.getArticleBody())
                        .title(request.getArticleTitle())
                        .subtitle(request.getArticleSubtitle())
                        .journalist(journalist.get())
                        .visible(false)
                        .build();

                articleRepository.save(article);
                return new ResponseEntity<>(new ExposeResponse("Article created"), HttpStatus.CREATED);
            }

            return new ResponseEntity<>(new ExposeResponse("Journalist not found"), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            LOGGER.error("POSTING ARTICLE: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
