package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Cliente;

public interface IClienteRepository {

	public Cliente buscar(String cedula);
}
