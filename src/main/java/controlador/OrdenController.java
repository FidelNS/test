package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Ordenes;
import serviciosImpl.OrdenServiceImpl;

@RestController
@RequestMapping(value = "/orden")
public class OrdenController {
	
	@Autowired
	private OrdenServiceImpl ordenServiceImpl;
	
	@GetMapping(value = "{/buscaORden}")
	public Ordenes getProductById(@PathVariable Long ordenId) {
		return ordenServiceImpl.getOrden(ordenId);
	}
	
	@PostMapping(value = "{/guardaOrden}")
	public Ordenes setOrden(@PathVariable Long ordenId, @RequestBody Ordenes orden){
		return ordenServiceImpl.setOrden(orden);		
	}
}
