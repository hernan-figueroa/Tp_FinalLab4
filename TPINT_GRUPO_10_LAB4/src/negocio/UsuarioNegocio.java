package negocio;

import java.util.ArrayList;

import entidades.Usuario;

public interface UsuarioNegocio {

	public boolean addUsuario(Usuario usuario);

	public boolean updateUsuario(String usuario, String clave , Integer tipoUsuario);

	public boolean deleteUsuario(String usuario, String Contrasenia);

	public ArrayList<Usuario> listarUsuarios();
}
