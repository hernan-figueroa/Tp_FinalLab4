package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.jdbc.Connection;

import dao.Dao;
import dao.UsuarioDao;
import entidades.Usuario;

public class UsuarioDaoImpl extends Dao implements UsuarioDao {

	@Override
	public boolean addUsuario(Usuario usuario) {
		int filas = 0;
		try {
			String sql = "INSERT INTO usuario(Usuario, Contraseña, TipoUsuario) "
					+ "values (" + usuario.getUsuario() + ", "+ usuario.getContrasenia() + ", "+ usuario.getTipoUsuario()+")";
			
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas > 0;
	}

	@Override
	public boolean updateUsuario(String usuario, String clave, Integer tipoUsuario) {
		int filas = 0;
		try {

			String sql = "Update Usuario SET Contraseña =" + clave + "',"
					+ "TipoUsuario =" + tipoUsuario +", WHERE usuario = '"+usuario+"'";
			
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas > 0;
	}

	@Override
	public boolean deleteUsuario(String usuario, String Contrasenia) {
		int filas=0;
		try {
			String sql = "Update Usuario SET estado = 0 WHERE usuario = " + usuario + " AND"
		      + " Contraseña = "+ Contrasenia;
			insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas>0;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		return null;
		
	}

	
	/*private Usuario getUsuario(ResultSet resultSet) throws SQLException
	{
		String Usuario = resultSet.getString("Usuario");
		String Contrasenia = resultSet.getString("Contraseña");
		int TipoUsuario = resultSet.getInt("TipoUsuario");
		return new Usuario(Usuario, Contrasenia, TipoUsuario);
	}*/
}
