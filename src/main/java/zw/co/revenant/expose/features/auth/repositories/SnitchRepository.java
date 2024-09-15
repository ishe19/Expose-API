package zw.co.revenant.expose.features.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.auth.models.entities.Snitch;

import java.util.Optional;

public interface SnitchRepository extends JpaRepository<Snitch, Long> {
    Optional<Snitch> findByUsername(String username);

    Optional<Snitch> findBySnitchCode(String snitchCode);
}
