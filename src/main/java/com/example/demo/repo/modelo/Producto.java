package com.example.demo.repo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	
	@Id
	@SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto", allocationSize = 1)
	@GeneratedValue(generator = "seq_producto", strategy = GenerationType.SEQUENCE)
	@Column(name = "prod_id")
	
	private Integer id;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_codigo_de_barras")
	private String codigoDeBarrasMaestro;
	@Column(name = "prod_categoria")
	private String categoria;
	@Column(name = "prod_stock")
	private Integer stock;
	
	@OneToMany(mappedBy = "producto",fetch =FetchType.LAZY )
	private List<Inventario>inventarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoDeBarrasMaestro() {
		return codigoDeBarrasMaestro;
	}

	public void setCodigoDeBarrasMaestro(String codigoDeBarrasMaestro) {
		this.codigoDeBarrasMaestro = codigoDeBarrasMaestro;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}


	
	
	
}
