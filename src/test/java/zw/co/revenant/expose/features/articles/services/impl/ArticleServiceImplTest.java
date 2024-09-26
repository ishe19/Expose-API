package zw.co.revenant.expose.features.articles.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;
import zw.co.revenant.expose.features.articles.repositories.ArticleMediaRepository;
import zw.co.revenant.expose.features.articles.repositories.ArticleRepository;
import zw.co.revenant.expose.features.auth.repositories.JournalistRepository;
import zw.co.revenant.expose.utils.DtoMapper;
import zw.co.revenant.expose.utils.models.ExposeResponse;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceImplTest {

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private ArticleMediaRepository articleMediaRepository;

    @Mock
    private DtoMapper dtoMapper;

    @Mock
    private JournalistRepository journalistRepository;

    @InjectMocks
    private ArticleServiceImpl authService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    ArticleServiceImpl getConstructor() {
        return new ArticleServiceImpl(articleRepository, articleMediaRepository, journalistRepository, dtoMapper);
    }

    // Fetch all articles successfully
    @Test
    public void test_fetch_all_articles_successfully() {
        ArticleServiceImpl articleService = getConstructor();

        List<Article> articles = List.of(new Article(), new Article());
        List<ArticleDto> articleDtos = List.of(new ArticleDto("code1", "title1", "subtitle1", "body1", "author1", new Date()),
                new ArticleDto("code2", "title2", "subtitle2", "body2", "author2", new Date()));

        when(articleRepository.findAll()).thenReturn(articles);
        when(dtoMapper.mapToArticleDto(any(Article.class))).thenReturn(articleDtos.get(0), articleDtos.get(1));

        ResponseEntity<ExposeResponse> response = articleService.getArticles();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(articleDtos, response.getBody().getData());
    }
}