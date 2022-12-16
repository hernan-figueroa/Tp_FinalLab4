package negocio;

import java.util.ArrayList;

import entidades.Admin;
import entidades.Usuario;

public interface AdminNegocio {
	public boolean addAdmin(Admin admin);

	public boolean deleteAdmin(String usuario);
	
	public ArrayList<Admin> listarAdmin();
	
	public Admin buscarSuperAdmin(String usu);
}
