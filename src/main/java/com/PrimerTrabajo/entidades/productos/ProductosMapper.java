package com.PrimerTrabajo.entidades.productos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ProductosMapper implements RowMapper<Productos> {
	
	//Clase para el tratamiento de datos de productos de la base de datos.
	@Override
	 public Productos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Productos p = new Productos();
		p.setId(rs.getInt("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getDouble("precio"));
        p.setUrl(rs.getString("url"));
        
		return p;
	
	}
	

}
