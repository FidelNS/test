package configuracion;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import serviciosImpl.UserDetailsServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {

    @Value("$jwt.secret")
	private String jwtSecret;
	
	@Value("$jwt.expiration")
	private int jwtExpiration;
	
	private final UserDetailsService userDetailsService;
	
	public JwtTokenProvider(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@PostConstruct
	protected void init() {
		jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
	}
	
	public String generaToken(String username, String rol) {
		//genera token
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("auth", rol);
		Date instante = new Date();
		Date expira = new Date(instante.getTime() + jwtExpiration);
		return Jwts.builder()
				.setClaims(claims) //user
				.setIssuedAt(instante) //inicio token
				.setExpiration(expira) //expira token
				.signWith(SignatureAlgorithm.HS512, jwtSecret) //algoritmo
				.compact();
	}
	
	public Authentication getAuthentication (String token) {
		
		//obtengo user
		String username = getUsername(token);
			
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	public String getUsername(String token) {
		//obtiene user
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public boolean validaToken(String authToken) {
		//valida token
		try {
			Jwts.parser()
			.setSigningKey(jwtSecret)
			.parseClaimsJws(authToken);
			return true;
		}catch(Exception e) {
			//si expiro u otros
		}
		return false;
	}
}
