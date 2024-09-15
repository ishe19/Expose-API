package zw.co.revenant.expose.features.articles.services.interfaces;

import org.springframework.http.ResponseEntity;
import zw.co.revenant.expose.features.articles.models.requests.PostArticleRequest;
import zw.co.revenant.expose.utils.models.ExposeResponse;

public interface ArticleService {
    ResponseEntity<ExposeResponse> getArticles();

    ResponseEntity<ExposeResponse> postArticle(PostArticleRequest request);
}
