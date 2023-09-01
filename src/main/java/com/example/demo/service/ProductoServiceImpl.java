package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IProductoRepo;
import com.example.demo.repo.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service

public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo iProductoRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crear(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepo.insertar(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iProductoRepo.encontrarPorCodigo(codigo);
	}

	@Override
	public void actualizarStock(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepo.actualizarStock(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Producto> buscarTodos() {
		
		return this.iProductoRepo.encontrarTodos();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Producto encontrarId(Integer id) {
		// TODO Auto-generated method stub
		return this.iProductoRepo.encontrarId(id);
	}

}
