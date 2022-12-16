package negocioImpl;

import java.util.ArrayList;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidades.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio{

	UsuarioDao uDao = new UsuarioDaoImpl();
	
	@Override
	public boolean addUsuario(Usuario usuario) {
		boolean estado = true;
		
		if(usuario.getUsuario().trim().length() > 0 && usuario.getContrasenia().trim().length() > 0) {
			estado = uDao.addUsuario(usuario);
		}
		return estado;
	}

	@Override
	public boolean updateUsuario(String usuario, String clave, Integer tipoUsuario) {
		boolean estado = true;
		
		if(usuario.trim().length() > 0 && clave.trim().length() > 0 && tipoUsuario > 0) {
			estado = uDao.updateUsuario(usuario, clave, tipoUsuario);
		}
		return estado;
	}

	@Override
	public boolean deleteUsuario(String usuario, String Contrasenia) {
		boolean estado = true;
		
		if(usuario.trim().length() > 0 && Contrasenia.trim().length() > 0) {
			estado = uDao.deleteUsuario(usuario, Contrasenia);
		}
		return estado;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> list = new ArrayList<Usuario>();
		
		list = uDao.listarUsuarios();
		
		return list;
	}

}
