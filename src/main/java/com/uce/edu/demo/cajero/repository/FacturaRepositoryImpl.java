package com.uce.edu.demo.cajero.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f JOIN f.detalles de WHERE de.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles de",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidad) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidad) {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad = :cantidad", Factura.class);
		myQuery.setParameter("cantidad", cantidad);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de",
				Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin(Integer cantidad) {
		return null;
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		return null;
	}

}
