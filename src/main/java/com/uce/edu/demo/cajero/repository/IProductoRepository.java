package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Producto;

public interface IProductoRepository {

	public void actualizar(Producto producto);

	public Producto buscar(String codigo);
}
