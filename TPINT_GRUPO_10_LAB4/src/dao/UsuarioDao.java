package dao;

import java.util.ArrayList;

import entidades.Usuario;

public interface UsuarioDao {

	public boolean addUsuario(Usuario usuario);

	public boolean updateUsuario(String clave , Integer tipoUsuario);

	public boolean deleteUsuario(Long id);

	public ArrayList<Usuario> listarUsuarios();
}
