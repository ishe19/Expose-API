package zw.co.revenant.expose.features.learning.models.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "learning_articles")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LearningArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String articleCode;
    private String title;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journalist_id", referencedColumnName = "id")
    private Journalist journalist;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdOn;
    @LastModifiedDate
    @Column(insertable = false)
    private Date updatedOn;
}
