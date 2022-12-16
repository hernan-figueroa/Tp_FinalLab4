package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AdminDao;
import dao.Dao;
import entidades.Admin;
import entidades.Localidad;
import entidades.TipoUsuario;
import entidades.Usuario;

public class AdminDaoImpl extends Dao implements AdminDao {

	@Override
	public boolean addAdmin(Admin admin) {
		int filas = 0;
		try {
			String sql = "INSERT INTO Admin(Usuario,Contrasenia, IdTipoUsuario, Estado, SuperAdmin,Mail) "
					+ "values('"+ admin.getUsuario() + "','" + admin.getContrasenia() + "',"
					+ admin.getTipoUsuario().getId() + "," + admin.isEstado() + "," + admin.isSuperAdmin() +",'"+admin.getMail()+"');";
			
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
	public boolean deleteAdmin(String usuario) {
		int filas=0;
		try {
			String sql = "Update Admin SET estado = 0 WHERE Usuario ='" + usuario + "';";
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas>0;
	}

	@Override
	public ArrayList<Admin> listarAdmin() {
		ArrayList<Admin> administradores = new ArrayList<Admin>();
		conectarBase();
		consultarBase("select * from Admin");
		try{
			while(resultado.next()){
				Admin admin = new Admin();
				admin.setUsuario(resultado.getString("Usuario"));
				admin.setContrasenia(resultado.getString("Contrasenia"));
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setId(resultado.getLong("idTipoUsuario"));
				admin.setTipoUsuario(tipoUsuario);
				admin.setEstado(resultado.getBoolean("estado"));
				admin.setSuperAdmin(resultado.getBoolean("estado"));
				
				administradores.add(admin);
			}
			desconectarBase();
		}catch(Exception e){
			administradores=null;
			e.printStackTrace();
		}
		return administradores;
	}
	
	public Admin buscarSuperAdmin(String usu) {
		Admin admin = new Admin();
		String sql = "Select SuperAdmin FROM admin WHERE Usuario= '"+usu+"'";
		
		try {
			consultarBase(sql);
			while(resultado.next()) {
				admin.setSuperAdmin(resultado.getBoolean(1));
			}
			
		}
		catch (Exception e) {
			desconectarBase();
			e.printStackTrace();
			return admin;
		}
		
		
		return admin;
	}

}
