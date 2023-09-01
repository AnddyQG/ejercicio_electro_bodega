package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Producto;

public interface IProductoService {

	public void crear(Producto producto);
	public Producto buscarPorCodigo(String codigo);
	
	public void actualizarStock(Producto producto);
	
	public Producto encontrarId(Integer id);
	public List<Producto> buscarTodos();
	
}
