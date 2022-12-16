package dao;

import java.sql.Date;
import java.util.ArrayList;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Login;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoUsuario;

public interface ClienteDao {
	
	public boolean addCliente(Cliente cliente);

	public boolean deleteCliente(Long id);

	public Login VerificarLogin(String OP,String usuario,String clave,String Mail);
	
	public Cliente listarCliente(Long id);
	
	public boolean updateCliente(Cliente cliente);
	
	public ArrayList<Localidad> listarLocalidad();
	
	public ArrayList<Nacionalidad> listarNacionalidad();
	
	public ArrayList<Provincia> listarProvincia();
	
	public ArrayList<TipoUsuario> listarTipoUsuarios();
	
	public ArrayList<Cliente> listarClientes();
	
	public Cliente buscarCliente(Long id);
	
	public TipoUsuario buscarTipoUsuarioPorId(Long idTipoUsuario);
	
	public boolean agregarPrestamo(Prestamo prestamo);

	boolean altaCliente(Long id);

	ArrayList<Prestamo> listarPrestamos(Date inicio, Date fin);

	Cliente buscarClientePorUsuario(String usuario);

	boolean DesaprobarPrestamo(Long id);
	
	public boolean AceptarPrestamos(Long idPrestamo);

	ArrayList<Prestamo> listarPrestamos();
	
	ArrayList<Prestamo> listarPrestamosCBU(Long CBU);

	boolean listarPrestamoPorId(int id);

	boolean InjectarPrestamo(double monto, Long cbu);

	boolean pagarCuotaPrestamo (Long IDPrestamo);
	

}
