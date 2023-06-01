package com.nhnacademy.residentmanage.config;

import com.nhnacademy.residentmanage.auth.CustomLoginSuccessHandler;
import com.nhnacademy.residentmanage.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                .requestMatchers("/certificate/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                .and()

                .requiresChannel()
                .requestMatchers("/certificate/**").requiresSecure()
                .anyRequest().requiresInsecure()
                .and()

                .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/login")
                .loginProcessingUrl("/login-process")
                .successHandler(loginSuccessHandler())
                .and()

                .oauth2Login()
                .loginPage("/login")
                .clientRegistrationRepository(clientRegistrationRepository())
                .authorizedClientService(authorizedClientService())
                .and()

                .csrf()
                .disable()

                .logout()
                .deleteCookies("SESSION")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .and()

                .sessionManagement()
                .sessionFixation()
                .none()
                .and()

                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CustomLoginSuccessHandler loginSuccessHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService(){
        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(github());
    }

    private ClientRegistration github(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .userNameAttributeName("name")
                .clientId("5ee3b7d5168cd54b07f5")
                .clientSecret("9adff691292d36b3ba4606a6a0be6ad31ad1e909")
                .build();
    }
}
