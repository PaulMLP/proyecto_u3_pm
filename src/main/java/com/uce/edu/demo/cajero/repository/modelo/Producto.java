package com.uce.edu.demo.cajero.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq_id")
	@SequenceGenerator(name = "prod_seq_id", sequenceName = "prod_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@Column(name = "prod_codigo_barras")
	private String codigoBarras;

	@Column(name = "prod_cantidad")
	private Integer cantidad;

	@OneToMany(mappedBy = "producto")
	private List<DetalleFactura> detalles;

	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", codigoBarras=" + codigoBarras
				+ ", cantidad=" + cantidad +"]";
	}

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

}
