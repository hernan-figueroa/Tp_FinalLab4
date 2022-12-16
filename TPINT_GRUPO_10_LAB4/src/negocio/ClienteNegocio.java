package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Login;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoUsuario;

public interface ClienteNegocio {

	 boolean addCliente(Cliente cliente);

//	public boolean updateCliente(Long idCliente, Long dni, Long cuit, String nombre, String apellido, String sexo,
//			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
//			String mail);

	 boolean deleteCliente(Long id);
	
	 boolean updateCliente(Cliente cliente);
	
	 Cliente listarCliente(Long id);
	
	ArrayList<Localidad> listarLocalidad();
	
	ArrayList<Nacionalidad> listarNacionalidad();
	
	ArrayList<Provincia> listarProvincia();
	
	ArrayList<TipoUsuario> listarTipoUsuarios();
	
	 Cliente buscarCliente(Long id);
	
	 ArrayList<Cliente> listarClientes();
	
	 TipoUsuario buscarTipoUsuarioPorId(Long idTipoUsuario);
	
	 ArrayList<Prestamo> listarPrestamos(java.sql.Date inicio , java.sql.Date fin);

	boolean AltaCliente(Long id);
	Cliente buscarClientePorUsuario(String usuario);
	
	boolean DesaprobarPrestamo(Long id);
	
	public boolean AceptarPrestamos(Long idPrestamo);
	
	ArrayList<Prestamo> listarPrestamos();

	boolean listarPrestamoPorId(int id);

	boolean InjectarPrestamo(double monto, Long cbu);
	
	public boolean agregarPrestamo(Prestamo prestamo);
	
	ArrayList<Prestamo> listarPrestamosCBU(Long CBU);
	
	boolean pagarCuotaPrestamo (Long IDPrestamo);
}
