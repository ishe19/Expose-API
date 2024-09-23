package zw.co.revenant.expose.features.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.learning.models.entities.LearningArticle;

public interface LearningArticleRepository extends JpaRepository<LearningArticle, Long> {
}
