package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.Productos;

public interface ProductoRepo extends JpaRepository<Productos, Long>{

}
