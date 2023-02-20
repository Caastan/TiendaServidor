package com.PrimerTrabajo.bbdd;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.PrimerTrabajo.entidades.productos.Productos;
import com.PrimerTrabajo.entidades.productos.ProductosMapper;
import com.PrimerTrabajo.entidades.productos.VentasBien;
import com.PrimerTrabajo.entidades.productos.VentasBienMapper;
import com.PrimerTrabajo.entidades.usuarios.UsuarioMapper;
import com.PrimerTrabajo.entidades.usuarios.Usuarios;
import com.PrimerTrabajo.entidades.ventas.Ventas;
import com.PrimerTrabajo.entidades.ventas.VentasMapper;

import jakarta.servlet.ServletException;





@Repository
public class Consultasrepositorios {
    @Autowired
    protected JdbcTemplate template;
    
    //Consulta para validar el usuario y devolverlo.
    public List<Usuarios> obtenerUsuario(String usuario, String pass) throws ServletException, IOException {
    	List<Usuarios> pedro = null;
    	try {
        return template.query("select * from usuarios where usuario ='"+usuario+"' and contrasena = '"+pass+"'", new UsuarioMapper());
        
    	}catch(Exception e) {
    		return pedro;
    	}
	    }
	    
	    //Consulta para coger todos los productos de la base de datos.
	    public List<Productos> obtenerProductos(){
	    	return template.query("select * from productos", new ProductosMapper());
	    }
	    
	    //Consulta para coger todas las ventas de la base de datos.
	    public List<Ventas> obtenerVentas(){
	    	return template.query("select * from ventas", new VentasMapper());
	    }
	    
	    //Aqui iría la consulta del insert que en vez de ser template.query sería template.execute
	    
	    public List<VentasBien> obtenerIdProducto(int idventa){
	    	return template.query("select * from productosventas WHERE idVentas = "+ idventa, new VentasBienMapper());
	    }
	    
	    public List<Productos> obtenernombreProductos(int idproducto){
	    	return template.query("select * from productos where id ="+idproducto, new ProductosMapper());
	    }
    
}