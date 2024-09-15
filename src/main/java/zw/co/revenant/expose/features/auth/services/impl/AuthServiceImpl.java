package zw.co.revenant.expose.features.auth.services.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zw.co.revenant.expose.features.auth.models.entities.Journalist;
import zw.co.revenant.expose.features.auth.models.entities.Snitch;
import zw.co.revenant.expose.utils.enums.UserType;
import zw.co.revenant.expose.features.sample.models.requests.LoginRequest;
import zw.co.revenant.expose.features.sample.models.requests.RegisterJournalistRequest;
import zw.co.revenant.expose.features.sample.models.requests.RegisterSnitchRequest;
import zw.co.revenant.expose.features.auth.models.responses.LoginResponse;
import zw.co.revenant.expose.features.auth.repositories.JournalistRepository;
import zw.co.revenant.expose.features.auth.repositories.SnitchRepository;
import zw.co.revenant.expose.features.auth.services.interfaces.AuthService;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final PasswordEncoder passwordEncoder;

    private final JournalistRepository journalistRepository;
    private final SnitchRepository snitchRepository;


    @Override
    public ResponseEntity<String> registerJournalist(RegisterJournalistRequest request) {
        try {
            Journalist journalist = Journalist
                    .builder()
                    .username(request.getUsername())
                    .journalistCode(UUID.randomUUID().toString())
                    .createdOn(new Date())
                    .email(request.getEmail())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();

            journalistRepository.save(journalist);

            return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.error("Journalist Registration error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> registerSnitch(RegisterSnitchRequest request) {
        try {
            Snitch snitch = Snitch
                    .builder()
                    .snitchCode(UUID.randomUUID().toString())
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();

            snitchRepository.save(snitch);

            return new ResponseEntity<>("Registration successful", HttpStatus.CREATED);

        } catch (Exception e) {
            LOGGER.error("Snitch Registration error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) {
        try {
            Optional<Snitch> snitch = snitchRepository.findByUsername(request.getUsername());
            if (snitch.isPresent()) {
                if (passwordEncoder.matches(request.getPassword(), snitch.get().getPassword())) {
                    return new ResponseEntity<>(new LoginResponse("Login Successful", UserType.SNITCH), HttpStatus.OK);
                } else return new ResponseEntity<>(new LoginResponse("Incorrect password"), HttpStatus.UNAUTHORIZED);
            } else {
                Optional<Journalist> journalist = journalistRepository.findByUsername(request.getUsername());
                if (journalist.isPresent()) {
                    if (passwordEncoder.matches(request.getPassword(), journalist.get().getPassword())) {
                        return new ResponseEntity<>(new LoginResponse("Login Successful", UserType.JOURNALIST), HttpStatus.OK);
                    } else
                        return new ResponseEntity<>(new LoginResponse("Incorrect password"), HttpStatus.UNAUTHORIZED);
                }
            }
            return new ResponseEntity<>(new LoginResponse("Failed to find user"), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            LOGGER.error("Login error : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
