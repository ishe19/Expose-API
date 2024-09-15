package zw.co.revenant.expose.features.articles.models.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostArticleRequest {
    private String articleTitle;
    private String articleSubtitle;
    private String articleBody;
    private String journalistCode;
}
