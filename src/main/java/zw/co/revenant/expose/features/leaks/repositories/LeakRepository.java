package zw.co.revenant.expose.features.leaks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.leaks.models.entities.Leak;

public interface LeakRepository extends JpaRepository<Leak, Long> {
}
