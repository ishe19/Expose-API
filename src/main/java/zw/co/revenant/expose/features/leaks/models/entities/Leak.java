package zw.co.revenant.expose.features.leaks.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.revenant.expose.features.auth.models.entities.Snitch;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "snitch_leaks")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Leak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String leakCode;
    private String title;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "snitch_id")
    private Snitch snitch;
    private Date createdOn;
    private Date updatedOn;
}
