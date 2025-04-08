package serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.Productos;
import repositorio.ProductoRepo;

@Service
public class ProductoServiceImpl {
	
	@Autowired
	private ProductoRepo productoRepo;
	
	public Productos modificaPrecio(Productos producto, double precio) {
		Productos newProduct = new Productos();
		newProduct.setCodigo(producto.getCodigo());
		newProduct.setDescripcion(producto.getDescripcion());
		newProduct.setOrdenId(producto.getOrdenId());
		newProduct.setPrecio(precio);
		newProduct.setProductoId(producto.getProductoId());
		return productoRepo.save(newProduct);
	}

}
