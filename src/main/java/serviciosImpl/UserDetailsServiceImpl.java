package serviciosImpl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import modelo.Usuarios;
import repositorio.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepo userRepo;
	
	public UserDetailsServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario " + username + " no encontrado"));
		
		return User.withUsername(usuario.getUsername())
				.password(usuario.getPalabraClave())
				.roles(usuario.getRol())
				.build();
	}
}
