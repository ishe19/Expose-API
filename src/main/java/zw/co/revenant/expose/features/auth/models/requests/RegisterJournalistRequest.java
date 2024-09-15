package zw.co.revenant.expose.features.auth.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterJournalistRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String email;
}
