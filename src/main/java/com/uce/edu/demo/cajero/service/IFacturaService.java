package com.uce.edu.demo.cajero.service;

import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaService {
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarFacturaInnerJoin();

	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad);

	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad);

	public List<Factura> buscarFacturaOuterLeftJoin();

	public List<Factura> buscarFacturaWhereJoin(Integer cantidad);

	public List<Factura> buscarFacturaFetchJoin(Integer cantidad);
}