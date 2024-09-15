package zw.co.revenant.expose.utils;

import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;

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
}
