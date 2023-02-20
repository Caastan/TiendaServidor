package com.PrimerTrabajo.entidades.carrito;

public class Carrito {
	 protected int id;
	 protected String nombre;
	 protected double precio;
	 
	 
	public Carrito() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
