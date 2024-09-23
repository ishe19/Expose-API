package zw.co.revenant.expose.utils;

import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;
import zw.co.revenant.expose.features.leaks.models.dto.LeakDto;
import zw.co.revenant.expose.features.leaks.models.entities.Leak;
import zw.co.revenant.expose.features.learning.models.dto.LearningArticleDto;
import zw.co.revenant.expose.features.learning.models.entities.LearningArticle;

public interface DtoMapper {
    ArticleDto mapToArticleDto(Article article);

    LeakDto mapToLeakDto(Leak leak);

    LearningArticleDto mapToLearningArticleDto(LearningArticle learningArticle);

}
