package zw.co.revenant.expose.features.articles.models.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "news_articles")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String articleCode;
    private String title;
    private String subtitle;
    @Column(length = 1500)
    private String body;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "journalist_id")
    private Journalist journalist;
    private boolean visible;

    private Date createdOn;
    private Date updatedOn;

}
