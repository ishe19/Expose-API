package zw.co.revenant.expose.features.articles.models.dto;

import java.util.Date;

public record ArticleDto(
        String articleCode,
        String title,
        String subtitle,
        String body,
        String articleBy,
        Date postedOn) {
}
