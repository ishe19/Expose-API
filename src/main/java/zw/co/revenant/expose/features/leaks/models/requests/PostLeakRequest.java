package zw.co.revenant.expose.features.leaks.models.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLeakRequest {
    private String title;
    private String description;
    private String body;
    private String snitchCode;
}
