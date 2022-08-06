package com.uce.edu.demo.cajero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IFacturaRepository;
import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		return this.facturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		return this.facturaRepository.buscarFacturaInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad) {
		return this.facturaRepository.buscarFacturaOuterRightJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad) {
		return this.facturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		return this.facturaRepository.buscarFacturaOuterLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		return this.facturaRepository.buscarFacturaWhereJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		return this.facturaRepository.buscarFacturaFetchJoin(cantidad);
	}

}
