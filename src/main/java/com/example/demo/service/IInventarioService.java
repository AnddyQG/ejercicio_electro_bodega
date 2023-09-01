package com.example.demo.service;

import java.util.List;

import com.example.demo.repo.modelo.Inventario;

public interface IInventarioService {

	public void ingresar(Inventario inventario);
	
	public List<Inventario> buscarTodos();

	public void borrar(Integer id);
	public Inventario buscar(Integer id);
	
}
