package zw.co.revenant.expose.features.auth.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSnitchRequest {
    private String username;
    private String password;
}
