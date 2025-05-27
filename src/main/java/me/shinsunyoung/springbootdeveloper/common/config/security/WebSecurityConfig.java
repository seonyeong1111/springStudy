package me.shinsunyoung.springbootdeveloper.common.config.security;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.springbootdeveloper.common.config.jwt.TokenAthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final TokenAthenticationFilter tokenAuthenticationFilter;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/static/**",
                        "/swagger-ui/**",                     // Swagger UI
                        "/swagger-ui.html",                   // Swagger UI 진입점
                        "/v2/api-docs",                       // Swagger 2 문서
                        "/v3/api-docs/**",                    // Swagger 3 문서
                        "/swagger-resources/**",              // Swagger 리소스
                        "/webjars/**",                        // Swagger 의존성
                        "/configuration/**");                   // Swagger 설정); //일반적으로 정적 리소스에 설정
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http    .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/members/signup","/login","/callback").permitAll() //나중에 추가하자
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home", true)
                )
                .formLogin(form -> form
                        .loginPage("/login") // 커스텀 로그인 페이지 URL
                        .defaultSuccessUrl("/home", true) // 로그인 성공 후 이동할 URL
                        .permitAll())
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                ).addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
