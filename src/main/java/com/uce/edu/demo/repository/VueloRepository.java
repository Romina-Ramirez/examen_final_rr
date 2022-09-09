package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepository implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> leerPorEstado(String origen, String destino, String fecha) {
		Query myNamedQuery = this.entityManager.createNamedQuery("Vuelo.buscarPorDisponibilidad");
		myNamedQuery.setParameter("origen", origen);
		myNamedQuery.setParameter("destino", destino);
		myNamedQuery.setParameter("fecha", fecha);
		return myNamedQuery.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo leerEstadoPorNumero(String numero) {
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero = :numero AND v.estado = 'DIS'", Vuelo.class);
		myQuery.setParameter("numero", numero);
		return myQuery.getSingleResult();
	}

}
