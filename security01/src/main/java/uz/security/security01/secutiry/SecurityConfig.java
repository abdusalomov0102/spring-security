package uz.security.security01.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static uz.security.security01.model.enums.Roles.*;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 10.06.2022
 * Time : 17:49
 * Project Name : security01
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private static final String[] PATH = {
            "/", "index", "/css/*", "/js/*"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(PATH).permitAll()
                .antMatchers("/api/**").hasAnyRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails newUserJaxongir = User.builder()
                .username("jaxongir")
                .password(passwordEncoder.encode("0000"))
                .authorities(STUDENT.getSimpleGrantedAuthorities())
                .build();

        UserDetails newUserAzamat = User.builder()
                .username("azamat")
                .password(passwordEncoder.encode("zamat"))
                .authorities(ADMIN.getSimpleGrantedAuthorities())
                .build();

        UserDetails newUserSardor = User.builder()
                .username("sardor")
                .password(passwordEncoder.encode("1234"))
                .authorities(ADMINTRAINEE.getSimpleGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                newUserJaxongir, newUserAzamat, newUserSardor
        );
    }

}
