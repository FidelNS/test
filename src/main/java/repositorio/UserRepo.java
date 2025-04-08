package repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Usuarios;

public interface UserRepo extends JpaRepository<Usuarios, Long>{
	Optional<Usuarios> findByUserName(String username);
}
