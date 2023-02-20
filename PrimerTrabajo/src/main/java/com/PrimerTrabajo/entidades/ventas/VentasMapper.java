package com.PrimerTrabajo.entidades.ventas;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.PrimerTrabajo.entidades.ventas.Ventas;

public class VentasMapper implements RowMapper<Ventas>{

	//Clase para el tratamiento de datos de usuario de la base de datos.
	   @Override
	    public Ventas mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Ventas v = new Ventas();
	        v.setId(rs.getInt("id"));
	        v.setNombre(rs.getString("nombre"));
	        v.setDireccion(rs.getString("direccion"));
	        v.setMunicipio(rs.getString("municipio"));
	        v.setProvincia(rs.getString("provincia"));
	        v.setCod_postal(rs.getInt("codigo_postal"));
	        v.setTelefono(rs.getInt("telefono"));
	        v.setPrecio(rs.getDouble("precio"));
	       
	        return v;
	    }
}
