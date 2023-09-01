package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Inventario;

public interface IInventarioRepo {
	
	public void insertar(Inventario inventario);
	
	public List<Inventario> encontrarTodos();
	
	public void eliminar(Integer id);
	public Inventario encontrar(Integer id);
	

}
