package com.example.demo.repo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	
	@Id
	@SequenceGenerator(name = "seq_inventario", sequenceName = "seq_inventario", allocationSize = 1)
	@GeneratedValue(generator = "seq_inventario", strategy = GenerationType.SEQUENCE)
	@Column(name = "inve_id")
	
	private Integer id;
	@Column(name = "inve_cantidad")
	private Integer cantidad;
	@Column(name = "inve_codigo_individual")
	private String codigoIndividual;
	
	
	@ManyToOne
	@JoinColumn(name = "inve_id_bodega")
	private Bodega bodega;
	
	@ManyToOne
	@JoinColumn(name = "inve_id_producto")
	private Producto producto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getCodigoIndividual() {
		return codigoIndividual;
	}

	public void setCodigoIndividual(String codigoIndividual) {
		this.codigoIndividual = codigoIndividual;
	}

	
	
	
	
}
