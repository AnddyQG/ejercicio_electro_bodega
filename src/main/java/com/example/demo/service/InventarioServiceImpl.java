package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IBodegaRepo;
import com.example.demo.repo.IInventarioRepo;
import com.example.demo.repo.IProductoRepo;
import com.example.demo.repo.modelo.Bodega;
import com.example.demo.repo.modelo.Inventario;
import com.example.demo.repo.modelo.Producto;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class InventarioServiceImpl implements IInventarioService{

	@Autowired
	private IInventarioRepo iInventarioRepo;
	
	@Autowired
	private IProductoRepo iProductoRepo;
	
	@Autowired
	private IBodegaRepo bodegaRepo;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void ingresar(Inventario inventario) {
		
		Producto producto=this.iProductoRepo.encontrarPorCodigo(inventario.getProducto().getCodigoDeBarrasMaestro());
		Bodega bodega=this.bodegaRepo.encontrarPorNumero(inventario.getBodega().getNumero());
		
		for(int i=1;i<=inventario.getCantidad();i++) {

			inventario.setBodega(bodega);
			inventario.setProducto(producto);
			inventario.setCantidad(inventario.getCantidad());
			String codigoNew=inventario.getProducto().getCodigoDeBarrasMaestro()+i;
			inventario.setCodigoIndividual(codigoNew);
			this.iInventarioRepo.insertar(inventario);
		}
		producto.setStock(inventario.getCantidad()+producto.getStock());
		this.iProductoRepo.actualizarStock(producto);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public List<Inventario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iInventarioRepo.encontrarTodos();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iInventarioRepo.eliminar(id);
	}

	@Override
	public Inventario buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iInventarioRepo.encontrar(id);
	}

}
