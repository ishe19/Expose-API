package zw.co.revenant.expose.features.auth.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.revenant.expose.utils.enums.UserType;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String message;
    private UserType user;
    private String userCode;

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, UserType user, String userCode) {
        this.message = message;
        this.user = user;
        this.userCode = userCode;
    }
}
