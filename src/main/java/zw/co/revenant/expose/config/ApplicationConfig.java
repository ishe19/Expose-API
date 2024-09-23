package zw.co.revenant.expose.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import zw.co.revenant.expose.audit.AppAuditAware;




@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AppAuditAware();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }


}
