package com.PrimerTrabajo.entidades.productos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VentasBienMapper implements RowMapper<VentasBien> {
	
	//Clase para el tratamiento de datos de productos de la base de datos.
	@Override
	 public VentasBien mapRow(ResultSet rs, int rowNum) throws SQLException {
		VentasBien v = new VentasBien();
		v.setIdProducto(rs.getInt("idProducto"));
        v.setIdVenta(rs.getInt("idVentas"));
        
		return v;
	
	}
	

}