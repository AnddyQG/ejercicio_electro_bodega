package com.example.demo.service;

import com.example.demo.repo.modelo.Bodega;

public interface IBodegaService {


	public void crear(Bodega bodega);
	
	public Bodega buscarPorNumero(String numero);
	
}
