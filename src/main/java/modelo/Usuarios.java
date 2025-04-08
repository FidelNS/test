package modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sucursales")
public class Usuarios {	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long usuarioId;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String palabraClave;
	
	@Column(nullable = false)
	private String rol;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPalabraClave() {
		return palabraClave;
	}

	public void setPalabraClave(String palabraClave) {
		this.palabraClave = palabraClave;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabraClave, rol, username, usuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(palabraClave, other.palabraClave) && Objects.equals(rol, other.rol)
				&& Objects.equals(username, other.username) && Objects.equals(usuarioId, other.usuarioId);
	}

}
