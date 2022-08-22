package com.uce.edu.demo.cajero.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_seq_id")
	@SequenceGenerator(name = "fact_seq_id", sequenceName = "fact_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "fact_fecha")
	private LocalDateTime fecha;

	@Column(name = "fact_numero")
	private String numero;
	
	@Column(name = "fact_monto")
	private BigDecimal monto;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DetalleFactura> detalles;
	
	@ManyToOne
	@JoinColumn(name = "fact_clie_id")
	private Cliente cliente;
	

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
}
