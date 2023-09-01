package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.modelo.Bodega;
import com.example.demo.service.IBodegaService;

@Controller
@RequestMapping("/bodegas")
public class BodegaController {

	@Autowired
	private IBodegaService bodegaService;
	
	@GetMapping("/vistaBodega")
	public String vistaBodega(Bodega bodega) {
		
		
		return "vistaInsertarBodega";
	}
	
	@PostMapping("/insertar")
	public String insertarBodega(Bodega bodega) {
		
		this.bodegaService.crear(bodega);
		
		return "redirect:/bodegas/vistaBodega";
	}
	
}
