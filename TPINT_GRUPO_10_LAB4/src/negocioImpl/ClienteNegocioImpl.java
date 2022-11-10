package negocioImpl;

import java.util.Date;
import java.util.List;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Localidad;
import entidades.Login;
import entidades.Nacionalidad;
import entidades.Provincia;
import negocio.ClienteNegocio;

public class ClienteNegocioImpl implements ClienteNegocio{

	ClienteDao cDao = new ClienteDaoImpl();
	
	@Override
	public boolean addCliente(Cliente cliente) {
		boolean estado = false;
		
		if(cliente.getDni() > 0 && cliente.getCuil() > 0) {
			if(cliente.getNombre().trim().length() > 0) {
				if(cliente.getApellido().trim().length() > 0) {
					if(cliente.getContrasenia().trim().length() > 0) {
						estado = cDao.addCliente(cliente);
					}
				}
			}
		}
		return estado;
	}

	@Override
	public boolean updateCliente(Long idCliente, Long dni, Long cuit, String nombre, String apellido, String sexo,
			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
			String mail) {
			boolean estado = false;
			
		if(dni > 0 && cuit > 0) {
			estado = cDao.updateCliente(idCliente, dni, cuit, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, mail);
		}
		return estado;
	}

	@Override
	public boolean deleteCliente(Long id) {
		boolean estado = false;
		
		if(id > 0) {
			estado = cDao.deleteCliente(id);
		}
		return estado;
	}

	@Override
	public Login VerificarLogin(Long DNI, String usuario, String clave) {
		Login login = new Login();
		
		if(DNI > 0 && usuario.trim().length() > 0 && clave.trim().length() > 0) {
			login.setDNI(DNI);
			login.setUsuario(usuario);
			login.setClave(clave);
		}
		return login;
	}

	

	
}
