package com.uce.edu.demo.cajero.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura_electronica")
public class FacturaElectronica {
	@Id
	@Column(name = "fael_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fael_seq_id")
	@SequenceGenerator(name = "fael_seq_id", sequenceName = "fael_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "fael_numero")
	private String numero;
	
	@Column(name = "fael_fecha")
	private LocalDateTime fecha;

	@Column(name = "fael_monto")
	private BigDecimal monto;
	
	@Column(name = "fael_numero_items")
	private Integer numeroItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getNumeroItems() {
		return numeroItems;
	}

	public void setNumeroItems(Integer numeroItems) {
		this.numeroItems = numeroItems;
	}

}
