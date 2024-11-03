package zw.co.revenant.expose.features.auth.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.revenant.expose.utils.enums.UserType;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String message;
    private UserType userType;
    private String userCode;

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, UserType userType, String userCode) {
        this.message = message;
        this.userType = userType;
        this.userCode = userCode;
    }
}
