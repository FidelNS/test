package modelo;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDENES")
public class Ordenes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDEN_ID", nullable = false)
	private Long ordenId;
	
	@ManyToOne
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
	private Long sucursalId;
	
	@Column(name = "FECHA", nullable = false)
	private Date fecha;
	
	@Column(name = "TOTAL", nullable = false)
	private double total;
	
	
	public Long getOrdenId() {
		return ordenId;
	}

	public void setOrdenId(Long ordenId) {
		this.ordenId = ordenId;
	}

	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, ordenId, sucursalId, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordenes other = (Ordenes) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(ordenId, other.ordenId)
				&& Objects.equals(sucursalId, other.sucursalId)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
	

}
