package com.uce.edu.demo.cajero.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.cajero.repository.IProductoRepository;
import com.uce.edu.demo.cajero.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarStock(List<Producto> productos) {
		for (Producto p : productos) {
			p.setCantidad(p.getCantidad() - 1);
			this.productoRepository.actualizar(p);
		}
	}

}
