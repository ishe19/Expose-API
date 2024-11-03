package zw.co.revenant.expose.features.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.revenant.expose.features.auth.models.requests.LoginRequest;
import zw.co.revenant.expose.features.auth.models.requests.RegisterJournalistRequest;
import zw.co.revenant.expose.features.auth.models.requests.RegisterSnitchRequest;
import zw.co.revenant.expose.features.auth.models.responses.LoginResponse;
import zw.co.revenant.expose.features.auth.services.interfaces.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register-journalist")
    public ResponseEntity<String> registerJournalist(@RequestBody RegisterJournalistRequest request) {
        return authService.registerJournalist(request);
    }

    @PostMapping("/register-snitch")
    public ResponseEntity<String> registerSnitch(@RequestBody RegisterSnitchRequest request) {
        return authService.registerSnitch(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }


}
