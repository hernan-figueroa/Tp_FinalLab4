package negocioImpl;

import java.util.ArrayList;

import daoImpl.AdminDaoImpl;
import entidades.Admin;
import entidades.Usuario;
import negocio.AdminNegocio;

public class AdminNegocioImpl implements AdminNegocio {
	
	private AdminDaoImpl adminDao = new AdminDaoImpl();

	@Override
	public boolean addAdmin(Admin admin) {
			
		return adminDao.addAdmin(admin);
	}

	@Override
	public boolean deleteAdmin(String usuario) {
		// TODO Auto-generated method stub
		return adminDao.deleteAdmin(usuario);
	}

	@Override
	public ArrayList<Admin> listarAdmin() {
		// TODO Auto-generated method stub
		return adminDao.listarAdmin();
	}
	
	public Admin buscarSuperAdmin(String usu) {
		return adminDao.buscarSuperAdmin(usu);
	}

}
