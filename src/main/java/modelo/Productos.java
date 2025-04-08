package modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCTO_ID", nullable = false)
	private Long productoId;
	
	@OneToMany
	@JoinColumn(name = "ORDEN_ID", nullable = false)
	private Long ordenId;
	
	@Column(name = "CODIGO", nullable = false)
	private String codigo;
	
	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;
	
	@Column(name = "PRECIO", nullable = false)
	private double precio;

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(Long ordenId) {
		this.ordenId = ordenId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, ordenId, precio, productoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return Objects.equals(descripcion, other.descripcion) && ordenId == other.ordenId
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& productoId == other.productoId;
	}
}
