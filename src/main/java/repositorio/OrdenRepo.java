package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Ordenes;

public interface OrdenRepo extends JpaRepository<Ordenes, Long>{	

}
