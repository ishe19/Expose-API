package zw.co.revenant.expose.utils;

import zw.co.revenant.expose.features.articles.models.dto.ArticleDto;
import zw.co.revenant.expose.features.articles.models.entities.Article;

public interface DtoMapper {
    ArticleDto mapToArticleDto(Article article);
}
