package zw.co.revenant.expose.features.leaks.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.revenant.expose.features.auth.models.entities.Snitch;
import zw.co.revenant.expose.features.auth.repositories.SnitchRepository;
import zw.co.revenant.expose.features.leaks.models.entities.Leak;
import zw.co.revenant.expose.features.leaks.models.requests.PostLeakRequest;
import zw.co.revenant.expose.features.leaks.repositories.LeakRepository;
import zw.co.revenant.expose.features.leaks.services.interfaces.LeaksService;
import zw.co.revenant.expose.utils.models.ExposeResponse;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LeaksServiceImpl implements LeaksService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeaksServiceImpl.class);

    private final LeakRepository leakRepository;
    private final SnitchRepository snitchRepository;

    @Override
    public ResponseEntity<ExposeResponse> postLeak(PostLeakRequest request) {
        try {
            Optional<Snitch> snitch = snitchRepository.findBySnitchCode(request.getSnitchCode());
            if (snitch.isPresent()) {
                Leak leak = Leak.builder()
                        .title(request.getTitle())
                        .leakCode(UUID.randomUUID().toString())
                        .description(request.getDescription())
                        .snitch(snitch.get())
                        .build();

                leakRepository.save(leak);

                return new ResponseEntity<>(new ExposeResponse("Leak posted"), HttpStatus.CREATED);
            }

            return new ResponseEntity<>(new ExposeResponse("User not found"), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            LOGGER.error("Posting leak error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
