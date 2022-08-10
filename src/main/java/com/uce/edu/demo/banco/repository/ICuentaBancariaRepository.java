package com.uce.edu.demo.banco.repository;

import com.uce.edu.demo.banco.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void actualizar(CuentaBancaria cuentaBancaria);

	public CuentaBancaria buscarPorNumero(String numero);
}
