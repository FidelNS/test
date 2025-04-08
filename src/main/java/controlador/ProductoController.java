package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Productos;
import serviciosImpl.ProductoServiceImpl;

@RestController
@RequestMapping(value = "/producto")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl productoServiceImpl;
			
	@PutMapping(value = {"/modificaPrecio"})
	public Productos modificaProducto(@PathVariable Long productoId, @RequestBody Productos producto, double precio){
		return productoServiceImpl.modificaPrecio(producto, precio);
	}

}
