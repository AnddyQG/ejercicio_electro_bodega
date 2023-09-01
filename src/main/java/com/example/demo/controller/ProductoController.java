package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.repo.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;
	
	
	@GetMapping("/vistaProducto")
	public String vistaPrducto(Producto producto) {
		
		return "vistaInsertarProducto";
	}
	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		producto.setStock(0);
		this.iProductoService.crear(producto);
		return "redirect:/productos/vistaProducto";
	}
	
	@GetMapping("/listaProductos")
	public String listaProd(Model model) {
		
		List<Producto>productos=this.iProductoService.buscarTodos();
		model.addAttribute("productos",productos);
		return "listaProductos";
	}
	@GetMapping("/buscar/{id}")
	public String buscarId(@PathVariable("id") Integer id,Model model) {
		Producto producto=this.iProductoService.encontrarId(id);
		model.addAttribute("producto",producto);
		
		return "vistaBuscarId";
	}
	@PutMapping("/actualizar/{id}")
	public String actualizar(@PathVariable("id") Integer id,Producto producto) {
		this.iProductoService.actualizarStock(producto);
		
		return "redirect:/productos/listaProductos";
	}
	
}
