package com.uce.edu.demo.cajero.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(FacturaElectronica facturaElectronica) {
		this.entityManager.persist(facturaElectronica);
		throw new RuntimeException();
	}

}