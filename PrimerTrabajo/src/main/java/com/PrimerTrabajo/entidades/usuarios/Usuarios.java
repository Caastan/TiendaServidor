package com.PrimerTrabajo.entidades.usuarios;
//Clase para guardar los usuarios.
public class Usuarios {
    protected int id;
    protected String login;
    protected String password;
    protected String nombre;
    protected String apellidos;
    protected String fecha;
    
    public Usuarios() {
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getApellidos() {
    	return apellidos;
    }
    
    public void setApellidos(String apellidos) {
    	this.apellidos = apellidos;
    }
}