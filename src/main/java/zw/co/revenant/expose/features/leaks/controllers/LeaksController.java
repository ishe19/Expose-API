package zw.co.revenant.expose.features.leaks.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.revenant.expose.features.leaks.models.requests.PostLeakRequest;
import zw.co.revenant.expose.features.leaks.services.interfaces.LeaksService;
import zw.co.revenant.expose.utils.models.ExposeResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/leaks")
public class LeaksController {

    private final LeaksService leaksService;


    @PostMapping("/")
    public ResponseEntity<ExposeResponse> postLeak(@RequestBody PostLeakRequest request){
        return leaksService.postLeak(request);
    }

    @GetMapping("/")
    public ResponseEntity<ExposeResponse> getLeaks(){
        return leaksService.getLeaks();
    }
}
