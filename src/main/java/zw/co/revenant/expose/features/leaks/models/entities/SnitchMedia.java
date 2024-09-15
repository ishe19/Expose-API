package zw.co.revenant.expose.features.leaks.models.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import zw.co.revenant.expose.features.auth.models.entities.Snitch;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "snitch_media")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SnitchMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "snitch_id")
    private Snitch snitch;
}
