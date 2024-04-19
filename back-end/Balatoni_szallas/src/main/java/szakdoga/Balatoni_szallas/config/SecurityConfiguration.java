package szakdoga.Balatoni_szallas.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;
import szakdoga.Balatoni_szallas.model.Role;
import szakdoga.Balatoni_szallas.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	private final JwtAuthenticationFilter jwtAuthenticationFilter ;
	
	private final UserService userService;
	
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.cors().configurationSource(corsConfigurationSource())
		.and()
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(request -> request.requestMatchers("/api/auth/**")
				.permitAll()
				.requestMatchers("/api/apartments/filtered").permitAll()
				.requestMatchers("/api/apartments/adview/**").permitAll()
				.requestMatchers("/api/reviews/view/**").permitAll()
				.requestMatchers("/api/admin/**").hasAnyAuthority(Role.ADMIN.name())
				.requestMatchers("/api/user/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/apartments/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reservations/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reviews/new").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reviews/user/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reviews/delete/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reviews/view/one/**").hasAnyAuthority(Role.USER.name())
				.requestMatchers("/api/reviews/edit/**").hasAnyAuthority(Role.USER.name())
				.anyRequest().authenticated())
				.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider()).addFilterBefore(
						jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
				);
				
				return http.build();
				
				
				
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService.userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager( AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	 @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(Arrays.asList("*"));
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	        configuration.setAllowedHeaders(Arrays.asList("*"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	
	
}
