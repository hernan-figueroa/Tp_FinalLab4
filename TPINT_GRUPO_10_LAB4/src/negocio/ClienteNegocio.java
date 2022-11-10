package negocio;

import java.util.Date;
import java.util.List;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Login;
import entidades.Nacionalidad;
import entidades.Provincia;

public interface ClienteNegocio {

	public boolean addCliente(Cliente cliente);

	public boolean updateCliente(Long idCliente, Long dni, Long cuit, String nombre, String apellido, String sexo,
			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
			String mail);

	public boolean deleteCliente(Long id);

	public Login VerificarLogin(Long DNI,String usuario,String clave);

}
