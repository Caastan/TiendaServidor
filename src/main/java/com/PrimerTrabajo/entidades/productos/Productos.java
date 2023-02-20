package com.PrimerTrabajo.entidades.productos;

//Clase para guardar los productos de la BBDD
public class Productos {
		protected int id;
		protected String nombre;
		protected double precio;
		protected String url;
	    
	    
	    public Productos() {
	        
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
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	   
}
