package zw.co.revenant.expose.utils.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExposeResponse {
    private String message;
    private List<String> errors;
    private Boolean success;
    private Object data;

    public ExposeResponse(String message) {
        this.message = message;
    }

    public ExposeResponse(Object data) {
        this.data = data;
    }

    public ExposeResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
