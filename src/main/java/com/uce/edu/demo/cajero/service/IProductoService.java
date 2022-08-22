package com.uce.edu.demo.cajero.service;

import java.util.List;

import com.uce.edu.demo.cajero.repository.modelo.Producto;

public interface IProductoService {

	public void actualizarStock(List<Producto> productos);
}
