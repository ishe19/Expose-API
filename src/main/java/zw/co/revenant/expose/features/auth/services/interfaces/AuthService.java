package zw.co.revenant.expose.features.auth.services.interfaces;

import org.springframework.http.ResponseEntity;
import zw.co.revenant.expose.features.sample.models.requests.LoginRequest;
import zw.co.revenant.expose.features.sample.models.requests.RegisterJournalistRequest;
import zw.co.revenant.expose.features.sample.models.requests.RegisterSnitchRequest;
import zw.co.revenant.expose.features.auth.models.responses.LoginResponse;

public interface AuthService {
    ResponseEntity<String> registerJournalist(RegisterJournalistRequest request);

    ResponseEntity<String> registerSnitch(RegisterSnitchRequest request);

    ResponseEntity<LoginResponse> login(LoginRequest request);
}
