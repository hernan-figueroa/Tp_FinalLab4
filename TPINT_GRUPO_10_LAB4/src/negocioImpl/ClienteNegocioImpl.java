package negocioImpl;

import java.util.ArrayList;
import java.util.Date;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidades.Cliente;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoUsuario;
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

//	@Override
//	public boolean updateCliente(Long idCliente, Long dni, Long cuit, String nombre, String apellido, String sexo,
//			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
//			String mail) {
//			boolean estado = false;
//			
//		if(dni > 0 && cuit > 0) {
//			estado = cDao.updateCliente(idCliente, dni, cuit, nombre, apellido, sexo, nacionalidad, fechaNac, direccion, localidad, provincia, mail);
//		}
//		return estado;
//	}

	@Override
	public boolean deleteCliente(Long id) {
		boolean estado = false;
		
		if(id > 0) {
			estado = cDao.deleteCliente(id);
		}
		return estado;
	}
	
	@Override
	public boolean AltaCliente(Long id) {
		boolean estado = true;
		
		if(id > 0) {
			estado = cDao.altaCliente(id);
		}
		return estado;
	}

	@Override
	public Cliente listarCliente(Long id) {
	
		return cDao.listarCliente(id);
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
			return cDao.updateCliente(cliente);
	}
	@Override
	public ArrayList<Localidad> listarLocalidad() {
		// TODO Auto-generated method stub
		return cDao.listarLocalidad();
	}

	@Override
	public ArrayList<Nacionalidad> listarNacionalidad() {
		// TODO Auto-generated method stub
		return cDao.listarNacionalidad();
	}

	@Override
	public ArrayList<Provincia> listarProvincia() {
		// TODO Auto-generated method stub
		return cDao.listarProvincia();
	}

	public ArrayList<TipoUsuario> listarTipoUsuarios(){
		return cDao.listarTipoUsuarios();
	}

	@Override
	public Cliente buscarCliente(Long id) {
		
		Cliente cli = null;
		
		if(id>0) {
		cli = cDao.buscarCliente(id);
		}

		return cli;
	}

	@Override
	public TipoUsuario buscarTipoUsuarioPorId(Long idTipoUsuario) {
		// TODO Auto-generated method stub
		return cDao.buscarTipoUsuarioPorId(idTipoUsuario);
	}
	@Override
	public ArrayList<Prestamo> listarPrestamos(java.sql.Date inicio , java.sql.Date fin){
		
		return cDao.listarPrestamos(inicio, fin);
	}

	@Override
	public ArrayList<Cliente> listarClientes() {
		
		// TODO Auto-generated method stub
		return cDao.listarClientes();
	}

	@Override
	public Cliente buscarClientePorUsuario(String usuario) {
		// TODO Auto-generated method stub
		return cDao.buscarClientePorUsuario(usuario);
	}

	@Override
	public boolean DesaprobarPrestamo(Long id) {
		// TODO Auto-generated method stub
		return cDao.DesaprobarPrestamo(id);
	}

	@Override
	public boolean AceptarPrestamos(Long idPrestamo) {
		// TODO Auto-generated method stub
		return cDao.AceptarPrestamos(idPrestamo);
	}

	@Override
	public ArrayList<Prestamo> listarPrestamos() {
		// TODO Auto-generated method stub
		return cDao.listarPrestamos();
	}

	@Override
	public boolean listarPrestamoPorId(int id) {
		// TODO Auto-generated method stub
		return cDao.listarPrestamoPorId(id);
	}

	@Override
	public boolean InjectarPrestamo(double monto, Long cbu) {
		// TODO Auto-generated method stub
		return cDao.InjectarPrestamo(monto, cbu);
	}

	@Override
	public boolean agregarPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return cDao.agregarPrestamo(prestamo);
	}

	@Override
	public ArrayList<Prestamo> listarPrestamosCBU(Long CBU) {
		// TODO Auto-generated method stub
		return cDao.listarPrestamosCBU(CBU);
	}

	@Override
	public boolean pagarCuotaPrestamo(Long IDPrestamo) {
		// TODO Auto-generated method stub
		return cDao.pagarCuotaPrestamo(IDPrestamo);
	}
	
}
