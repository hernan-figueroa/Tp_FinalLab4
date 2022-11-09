package daoImpl;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Nacionalidad;
import entidades.Provincia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.ClienteDao;
import dao.Dao;

public class ClienteDaoImpl extends Dao implements ClienteDao {

	public ArrayList<String> VerificarLogin(String DNI, String usuario, String Clave) {
		ArrayList<String> Resultado = new ArrayList<String>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{call Login(?,?,?)}");
			conectarBase(); // inicio conexion con base de datos

			ps = conexion.prepareCall(sb.toString());
			ps.setString(1, DNI);
			ps.setString(2, usuario);
			ps.setString(3, Clave);
			consultarBasePS(); // ejecuto el PreparedStatement: resultado=ps.executeQuery();

			System.out.println("Antes de entrar a resultado");
			if (resultado.next()) {
				Resultado.add(resultado.getString("Validacion"));
				Resultado.add(resultado.getString("TipoUsuario"));
			}

			ps.close();
			desconectarBase();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarBase();
		}

		return Resultado;

	}

	@Override
	public boolean addCliente(Cliente cliente) {

		int filas = 0;
		try {
			String sql = "INSERT INTO Cliente(idCliente, CUIL,Nombre, Apellido, Sexo, IDNacionalidad,"
					+ " FechaNacimiento, Direccion, IDLocalidad, IDProvincia, Mail, Usuario, Estado, DNI)" 
					+ "values (" + cliente.getId() + "," + cliente.getCuil() + ",' " + cliente.nombre + "','"
					+ cliente.getApellido() + "','" + cliente.getSexo() + "' ," + cliente.getNacionalidad().getId() + ","
					+ cliente.getFechaNac() + ", '" + cliente.getDireccion() + "'," + cliente.getLocalidad().getId() + ","
					+ cliente.getProvincia() + ",'" + cliente.getMail() + "','" + cliente.getUsuario().getUsuario() + "',"
					+ cliente.getEstado() + "," + cliente.getDni() + ");";
			
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas > 0;
	}

	@Override
	public boolean updateCliente(Long idCliente, Long dni, Long cuil, String nombre, String apellido, String sexo,
			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
			String mail) {
		int filas = 0;
		try {

			String sql = "Update Cliente SET idCliente =" + idCliente + ","
					+ "CUIL =" + cuil +","
					+"Nombre='" + nombre + "',"
					+ "Apellido='" + apellido + "',"
					+ "Sexo='" + sexo + "',"
					+ "IDNacionalidad=" + nacionalidad.getId() + ","
					+ "FechaNacimiento=" + fechaNac + ","
					+ "Direccion='" + direccion + "',"
					+ "IDLocalidad=" + localidad.getId() + ","
					+ "IDProvincia=" + provincia.getId() + ","
					+ "Mail='" + mail + "',"
					+ "DNI=" + dni + ";"; 
			
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return filas > 0;
	}

	@Override
	public boolean deleteCliente(Long id) {
		int filas=0;
		try {
			String sql = "Update Cliente estado = 0 WHERE idCliente = " + id + ";";
			insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas>0;
	}

}
