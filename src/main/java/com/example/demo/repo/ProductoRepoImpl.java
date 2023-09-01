package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto encontrarPorCodigo(String codigo) {
String jpql="SELECT p FROM Producto p WHERE p.codigoDeBarrasMaestro =:datoCodigo";
TypedQuery<Producto>query=this.entityManager.createQuery(jpql,Producto.class);
		query.setParameter("datoCodigo", codigo);
		return query.getSingleResult();
	}

	@Override
	public void actualizarStock(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> encontrarTodos() {
		String jpql="SELECT p FROM Producto p";
		TypedQuery<Producto>query=this.entityManager.createQuery(jpql,Producto.class);
				
				return query.getResultList();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto encontrarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

}
