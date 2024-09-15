package zw.co.revenant.expose.features.leaks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.leaks.models.entities.SnitchMedia;

public interface SnitchMediaRepository extends JpaRepository<SnitchMedia, Long> {
}
