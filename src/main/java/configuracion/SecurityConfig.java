package configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	private final JwtTokenProvider jwtTokenProvider;
	
	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.requestMatchers("/api/auth/**").permitAll()
		.requestMatchers("/h2-console/**").permitAll()
		//para servicios. suponiendo que existen roles.
		.requestMatchers(HttpMethod.POST, "/api/ordenes").hasAnyRole("DEFAULT","USER")
		.requestMatchers(HttpMethod.GET, "/api/ordenes").hasAnyRole("DEFAULT","USER")
		.requestMatchers(HttpMethod.PUT, "/api/productos/**").hasAnyRole("DEFAULT","USER")
		.anyRequest().authenticated()
		.and()
		.headers().frameOptions().sameOrigin() //H2
		.and()
		.apply(new JwtConfigurer(jwtTokenProvider));
	}
}
