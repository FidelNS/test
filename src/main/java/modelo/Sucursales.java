package modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SUCURSALES")
public class Sucursales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUCURSAL_ID", nullable = false)
	private Long sucursalId;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	
	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, sucursalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sucursales other = (Sucursales) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(sucursalId, other.sucursalId);
	}
}
