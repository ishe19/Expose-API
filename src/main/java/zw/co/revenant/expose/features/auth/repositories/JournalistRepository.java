package zw.co.revenant.expose.features.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;

import java.util.Optional;

public interface JournalistRepository extends JpaRepository<Journalist, Long> {

    Optional<Journalist> findByUsername(String username);

    Optional<Journalist> findByJournalistCode(String journalistCode);
}
