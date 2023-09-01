package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IBodegaRepo;
import com.example.demo.repo.modelo.Bodega;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepo bodegaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crear(Bodega bodega) {
		this.bodegaRepo.insertar(bodega);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public Bodega buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bodegaRepo.encontrarPorNumero(numero);
	}

}
