package zw.co.revenant.expose.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("expos3")) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username("expos3")
                .password(passwordEncoder.encode("Expos3_revenant987")) // Ensure the password is encoded
                .roles("USER")
                .build();
    }
}

