package com.uce.edu.demo.cajero.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_seq_id")
	@SequenceGenerator(name = "clie_seq_id", sequenceName = "clie_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "clie_numero_cedula")
	private String numeroCedula;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Factura> facturas;

	// SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCedula() {
		return numeroCedula;
	}

	public void setNumeroCedula(String numeroCedula) {
		this.numeroCedula = numeroCedula;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
