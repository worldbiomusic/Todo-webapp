package io.github.webapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // HTTP 보안 설정
                .authorizeHttpRequests(authz -> authz
                        // /login은 인증 필요없음
                        .requestMatchers("/login").permitAll()
                        // 나머지 요청 인증 필요
                        .anyRequest().authenticated())
                // 폼 로그인 설정
                .formLogin(form -> form
                        // 커스텀 로그인 URL 설정
                        .loginPage("/login")
                        .loginProcessingUrl("/authentication")
                        .usernameParameter("usernameInput")
                        .passwordParameter("passwordInput")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error"))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }
}
