package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Producto;

public interface IProductoRepo {

	public void insertar(Producto producto);
	public Producto encontrarPorCodigo(String codigo);
	public void actualizarStock(Producto producto);
	public Producto encontrarId(Integer id);
	public List<Producto> encontrarTodos();
	
}
