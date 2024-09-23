package zw.co.revenant.expose.features.leaks.services.interfaces;

import org.springframework.http.ResponseEntity;
import zw.co.revenant.expose.features.leaks.models.requests.PostLeakRequest;
import zw.co.revenant.expose.utils.models.ExposeResponse;

public interface LeaksService {
    ResponseEntity<ExposeResponse> postLeak(PostLeakRequest request);

    ResponseEntity<ExposeResponse> getLeaks();

}
