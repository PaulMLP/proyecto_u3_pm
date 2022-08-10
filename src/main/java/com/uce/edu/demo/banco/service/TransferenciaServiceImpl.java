package com.uce.edu.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.banco.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.banco.repository.ITransferenciaRepository;
import com.uce.edu.demo.banco.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.banco.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository transferenciaRepository;

	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// 0. Busque la cta Origen (obtener el saldo)
		// 1. Restar el monto a la cta origen
		CuentaBancaria ctaOrigen = this.cuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
		this.cuentaBancariaRepository.actualizar(ctaOrigen);

		// 0. Busque la cta Destino (obtener el saldo)
		// 1. Sumar el monto a la cta destino
		CuentaBancaria ctaDestino = this.cuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaBancariaRepository.actualizar(ctaDestino);

		// 2. Insertar Transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(trans);

	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		this.realizarTransferencia(numeroCtaOrigen, numeroCtaDestino, monto);
	}

}
