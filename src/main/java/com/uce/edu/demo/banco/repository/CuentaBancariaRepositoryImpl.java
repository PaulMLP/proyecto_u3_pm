package com.uce.edu.demo.banco.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.banco.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {

	private static Logger LOG = Logger.getLogger(CuentaBancariaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		LOG.info("Actualizacion de Cuenta Bancaria");
		LOG.info("Transaccion activa repository: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		LOG.info("Busqueda por Numero de Cuenta Bancaria");
		LOG.info("Transaccion activa repository: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero = :numeroCuba", CuentaBancaria.class);
		myQuery.setParameter("numeroCuba", numero);
		return myQuery.getSingleResult();
	}
}
