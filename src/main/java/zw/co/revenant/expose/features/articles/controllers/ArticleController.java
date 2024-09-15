package zw.co.revenant.expose.features.articles.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.revenant.expose.features.articles.models.requests.PostArticleRequest;
import zw.co.revenant.expose.features.articles.services.interfaces.ArticleService;
import zw.co.revenant.expose.utils.models.ExposeResponse;

@RequestMapping("/articles")
@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/")
    public ResponseEntity<ExposeResponse> getArticles(){
        return articleService.getArticles();
    }

    @PostMapping("/")
    public ResponseEntity<ExposeResponse> postArticle(@RequestBody PostArticleRequest request){
        return articleService.postArticle(request);
    }
}
