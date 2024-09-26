package zw.co.revenant.expose.utils;

import org.springframework.stereotype.Component;
import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;
import zw.co.revenant.expose.features.leaks.models.dto.LeakDto;
import zw.co.revenant.expose.features.leaks.models.entities.Leak;
import zw.co.revenant.expose.features.learning.models.dto.LearningArticleDto;
import zw.co.revenant.expose.features.learning.models.entities.LearningArticle;


@Component
public class DtoMapperImpl implements DtoMapper {
    @Override
    public ArticleDto mapToArticleDto(Article article) {
        return new ArticleDto(
                article.getArticleCode(),
                article.getTitle(),
                article.getSubtitle(),
                article.getBody(),
                String.format("%s %s", article.getJournalist().getFirstName(), article.getJournalist().getLastName()),
                article.getCreatedOn()
        );
    }

    @Override
    public LeakDto mapToLeakDto(Leak leak) {
        return new LeakDto(
                leak.getTitle(),
                leak.getLeakCode(),
                leak.getDescription(),
                leak.getCreatedOn()
        );
    }

    @Override
    public LearningArticleDto mapToLearningArticleDto(LearningArticle learningArticle) {
        return new LearningArticleDto(
                learningArticle.getArticleCode(),
                learningArticle.getTitle(),
                learningArticle.getBody(),
                String.format("%s %s", learningArticle.getJournalist().getFirstName(), learningArticle.getJournalist().getLastName()),
                learningArticle.getCreatedOn()
        );
    }
}
