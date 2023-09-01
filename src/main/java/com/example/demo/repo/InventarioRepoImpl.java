package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class InventarioRepoImpl implements IInventarioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(inventario);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Inventario> encontrarTodos() {
		String jpql="SELECT e FROM Inventario e";
		TypedQuery<Inventario>query=this.entityManager.createQuery(jpql,Inventario.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(Integer id) {
	Inventario inventario=this.encontrar(id);
		
		this.entityManager.remove(inventario);
	}

	@Override
	public Inventario encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Inventario.class, id);
	}

}
