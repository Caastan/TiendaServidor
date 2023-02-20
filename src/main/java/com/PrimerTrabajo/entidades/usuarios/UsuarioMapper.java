package com.PrimerTrabajo.entidades.usuarios;
import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper<Usuarios>{

	//Clase para el tratamiento de datos de usuario de la base de datos.
   @Override
    public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuarios u = new Usuarios();
        u.setId(rs.getInt("id"));
        u.setLogin(rs.getString("usuario"));
        u.setPassword(rs.getString("contrasena"));
        u.setNombre(rs.getString("nombre"));
        u.setApellidos(rs.getString("apellidos"));
        u.setFecha(rs.getString("fechaN"));
       
        return u;
    }
    
}