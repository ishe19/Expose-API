package zw.co.revenant.expose.features.learning.models.dto;

import java.util.Date;

public record LearningArticleDto(String articleCode, String title, String body, String author, Date postedOn) {
}
