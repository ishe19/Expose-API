package zw.co.revenant.expose;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "EXPOSE API", version = "0.1", description = "REST API for EXPOSE "))
public class ExposeApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExposeApiApplication.class, args);
    }
}
