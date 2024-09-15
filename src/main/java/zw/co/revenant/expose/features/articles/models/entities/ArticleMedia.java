package zw.co.revenant.expose.features.articles.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "article_media")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ArticleMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "journalist_id")
    private Journalist journalist;
}
