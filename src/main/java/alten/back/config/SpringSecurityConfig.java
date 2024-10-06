package alten.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService; 

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	return http
			.csrf().disable() // Désactiver la protection CSRF
			.authorizeHttpRequests(auth -> {

		auth.requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll();
		
		auth.requestMatchers(HttpMethod.GET, "/api/products").hasAnyRole("USER","ADMIN");
		
		auth.requestMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("USER","ADMIN");
		
		auth.requestMatchers(HttpMethod.POST, "/api/products").hasRole("ADMIN");
		
		auth.requestMatchers(HttpMethod.PATCH, "/api/products/**").hasRole("ADMIN");
		
		auth.requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN");
		
		auth.anyRequest().authenticated();
	})
	        .httpBasic(Customizer.withDefaults()) 
			//.formLogin(Customizer.withDefaults())
			.build();
}
@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**") // Autorise toutes les requêtes vers toutes les URL
                    .allowedOrigins("http://localhost:4200") // Remplacez par l'URL de votre application Angular
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                    .allowCredentials(true);
        }
    };
}
	
@Bean
public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}	

@Bean
public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
	AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
	authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	return authenticationManagerBuilder.build();
}

}
