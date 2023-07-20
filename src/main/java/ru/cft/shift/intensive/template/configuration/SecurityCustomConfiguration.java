package ru.cft.shift.intensive.template.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import ru.cft.shift.intensive.template.configuration.security.CustomConfigurer;

@Configuration
public class SecurityCustomConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> requests
        .requestMatchers("store").permitAll()
            .requestMatchers("/store/**").permitAll()
            .requestMatchers("auth").permitAll()
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/orders/**").hasAnyRole("ADMIN", "USER")
            .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/actuator/**").permitAll())
            .formLogin((form) -> form
                    .loginPage("/auth")
                    .permitAll()
            )
            .logout((logout) -> logout.permitAll());
    http.cors(configurer -> configurer.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()));
    http.csrf(AbstractHttpConfigurer::disable);
    http.apply(new CustomConfigurer<>());
    http.logout(configurer -> configurer.logoutSuccessUrl("/auth/success"));
    //http.httpBasic(Customizer.withDefaults());
    http.apply(new CustomConfigurer<>());
    return http.build();
//    http
//            .authorizeHttpRequests((requests) -> requests
//                    .requestMatchers("/", "/store").permitAll()
//                    .anyRequest().authenticated()
//            )
//            .formLogin((form) -> form
//                    .loginPage("/login")
//                    .permitAll()
//            )
//            .logout((logout) -> logout.permitAll());
//
//    return http.build();
  }
}
