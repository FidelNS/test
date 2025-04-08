package serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.Ordenes;
import repositorio.OrdenRepo;

@Service
public class OrdenServiceImpl {
	
	@Autowired
	OrdenRepo ordenRepo;
	
	public Ordenes getOrden(Long id) {
		return ordenRepo.getById(id);
	}
	
	public Ordenes setOrden(Ordenes orden) {
		return ordenRepo.save(orden);
	}

}
