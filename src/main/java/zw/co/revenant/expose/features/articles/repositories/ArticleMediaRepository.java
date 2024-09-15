package zw.co.revenant.expose.features.articles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.articles.models.entities.ArticleMedia;

public interface ArticleMediaRepository extends JpaRepository<ArticleMedia, Long> {
}
