package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Inventario;
import com.example.demo.service.IInventarioService;

@Controller
@RequestMapping("/inventarios")
public class InventarioController {

	@Autowired
	private IInventarioService iInventarioService;
	
	@GetMapping("/vistaInventario")
	public String vistaInventario(Inventario inventario) {
		
		return "vistaInsertarInventarios";
	}
	@PostMapping("/insertar")
	public String insertarInventario(Inventario inventario) {
		this.iInventarioService.ingresar(inventario);
		
		return "redirect:/inventarios/listaInventario";
	}
	@GetMapping("/listaInventario")
	public String listaInve(Model model) {
		
		List<Inventario>inventarios=this.iInventarioService.buscarTodos();
		model.addAttribute("inventarios",inventarios);
		
		return "vistaListaInventario";
	}
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id")Integer id) {
		
		this.iInventarioService.borrar(id);
		
		return "redirect:/inventarios/listaInventario";
	}
	
}
