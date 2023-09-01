package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class BodegaRepoImpl implements IBodegaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bodega);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Bodega encontrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		String jpql="SELECT b FROM Bodega b WHERE b.numero=:datoNumero";
		TypedQuery<Bodega>query=this.entityManager.createQuery(jpql,Bodega.class);
		query.setParameter("datoNumero", numero);
		
		return query.getSingleResult();
	}

}
