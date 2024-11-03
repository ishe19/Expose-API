package zw.co.revenant.expose.features.learning.services.interfaces;

import org.springframework.http.ResponseEntity;
import zw.co.revenant.expose.features.articles.models.requests.PostArticleRequest;
import zw.co.revenant.expose.utils.models.ExposeResponse;

public interface LearningService {
    ResponseEntity<ExposeResponse> getArticles();

    ResponseEntity<ExposeResponse> postLearningArticle(PostArticleRequest request);
}
