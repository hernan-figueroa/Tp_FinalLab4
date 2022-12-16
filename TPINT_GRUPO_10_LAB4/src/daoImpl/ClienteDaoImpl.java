package daoImpl;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Login;
import entidades.Nacionalidad;
import entidades.Prestamo;
import entidades.Provincia;
import entidades.TipoCuenta;
import entidades.TipoUsuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Excepciones.FaltaArrobaException;
import Excepciones.FaltaPuntoException;
import dao.ClienteDao;
import dao.Dao;

public class ClienteDaoImpl extends Dao implements ClienteDao {

	public Login VerificarLogin(String OP, String usuario, String Clave, String Mail) {
		Login userLog = new Login();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{call Login(?,?,?,?)}");
			conectarBase(); // inicio conexion con base de datos

			ps = conexion.prepareCall(sb.toString());
			ps.setString(1, OP);
			ps.setString(2, usuario);
			ps.setString(3, Clave);
			ps.setString(4, Mail);
			consultarBasePS(); // ejecuto el PreparedStatement: resultado=ps.executeQuery();

			if (resultado.next()) {
				if (OP.equals("Login")) {
					userLog.setUsuario(resultado.getString("usuario"));
					userLog.setClave(resultado.getString("Clave"));
					userLog.setAdmin(resultado.getBoolean("TipoUsuario"));
				} else if (OP.equals("RecuperarUsuario")) {
					userLog.setMail(resultado.getString("Mail"));
					userLog.setUsuario(resultado.getString("usuario"));
					userLog.setClave(resultado.getString("Clave"));
				}
			}
			ps.close();
			desconectarBase();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarBase();
			userLog = null;
		}

		return userLog;

	}

	@Override
	public boolean addCliente(Cliente cliente) {

		System.out.println(cliente);
		int filas = 0;
		try {
			String sql = "INSERT INTO Cliente(CUIL,Nombre, Apellido, Sexo, IDNacionalidad,"
					+ " FechaNacimiento, Direccion, IDLocalidad, IDProvincia, Mail, Usuario, Estado, DNI , contrasenia , idTipoUsuario)"
					+ "values ('" + cliente.getCuil() + "','" + cliente.getNombre() + "','" + cliente.getApellido()
					+ "','" + cliente.getSexo() + "' ,'" + cliente.getNacionalidad().toString() + "','"
					+ cliente.getFechaNac() + "', '" + cliente.getDireccion() + "','" + cliente.getLocalidad().toString()
					+ "','" + cliente.getProvincia().toString() + "','" + cliente.getMail() + "','" + cliente.getUsuario()
					+ "', True ,'" + cliente.getDni() + "', '" + cliente.getContrasenia() + "','"
					+ 0 + "')";

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
	public boolean updateCliente(Cliente cliente) {
		int filas = 0;
		try {

			// System.out.println();
			String sql = "UPDATE `tp_final`.`cliente` SET `CUIL`='" + cliente.getCuil() + "'," + "`Nombre`='"
					+ cliente.getNombre() + "', `Apellido`='" + cliente.getApellido() + "'," + " `Sexo`='"
					+ cliente.getSexo() + "'," + "IDNacionalidad='" + cliente.getNacionalidad().getId() + "',"
					+ "FechaNacimiento='" + cliente.getFechaNac() + "'," + "Direccion='" + cliente.getDireccion()
					+ "',IDLocalidad=" + cliente.getLocalidad().getId() + "," + "IDProvincia="
					+ cliente.getProvincia().getId() + ", Mail='" + cliente.getMail() + "'," + "DNI='"
					+ cliente.getDni() + "'," + "Contrasenia ='" + cliente.getContrasenia() + "' WHERE idCliente ="
					+ cliente.getId() + ";";

			filas = insertarModificarEliminar(sql);
		}catch(FaltaArrobaException e)
		{
			System.out.println("Error Falta Arroba");
			e.printStackTrace();
		}catch (FaltaPuntoException e)
		{
			System.out.println("Error Falta Punto");
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
		return filas > 0;
	}
	

	@Override
	public boolean deleteCliente(Long id) {
		int filas = 0;
		try {
			String sql = "Update Cliente SET estado = 0 WHERE idCliente = " + id + ";";
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas > 0;
	}

	@Override
	public boolean altaCliente(Long id) {
		int filas = 0;
		try {
			String sql = "Update Cliente SET estado = 1 WHERE idCliente = " + id + ";";
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas > 0;

	}

	@Override
	public Cliente listarCliente(Long id) {
		Cliente cliente = new Cliente();
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();
		Provincia prov = new Provincia();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{call Cliente(?,?)}");
			conectarBase(); // inicio conexion con base de datos

			ps = conexion.prepareCall(sb.toString());
			ps.setString(1, "ListarCliente");
			ps.setLong(2, id);
			consultarBasePS(); // ejecuto el PreparedStatement: resultado=ps.executeQuery();

			if (resultado.next()) {
				cliente.setId(resultado.getLong("idCliente"));
				cliente.setDni(resultado.getLong("DNI"));
				cliente.setCuil(resultado.getLong("CUIL"));
				cliente.setUsuario(resultado.getString("Usuario"));
				cliente.setContrasenia(resultado.getString("Contrasenia"));
				cliente.setNombre(resultado.getString("Nombre"));
				cliente.setApellido(resultado.getString("Apellido"));
				cliente.setSexo(resultado.getString("Sexo"));
				nac.setDescripcion(resultado.getString("DescripcionNac"));
				nac.setId(resultado.getLong("idNacionalidad"));
				cliente.setNacionalidad(nac);
				cliente.setFechaNac(resultado.getDate("FechaNacimiento"));
				loc.setDescripcion(resultado.getString("DescripcionLoc"));
				loc.setId(resultado.getLong("idLocalidad"));
				cliente.setLocalidad(loc);
				prov.setDescripcion(resultado.getString("DescripcionProv"));
				prov.setId(resultado.getLong("idProvincia"));
				cliente.setProvincia(prov);
				cliente.setDireccion(resultado.getString("Direccion"));
				cliente.setMail(resultado.getString("Mail"));
				cliente.setEstado(resultado.getBoolean("Estado"));

			} else
				cliente = null;

			ps.close();
			desconectarBase();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarBase();
			cliente = null;
		}
		return cliente;
	}

	@Override
	public ArrayList<Localidad> listarLocalidad() {

		ArrayList<Localidad> lista = new ArrayList<Localidad>();
		conectarBase();
		consultarBase("select * from localidad");
		try {
			while (resultado.next()) {
				Localidad loc = new Localidad();
				loc.setId(resultado.getLong("idLocalidad"));
				loc.setDescripcion(resultado.getString("Descripcion"));

				lista.add(loc);
			}
			desconectarBase();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return lista;
	}

	@Override
	public ArrayList<Nacionalidad> listarNacionalidad() {
		// TODO Auto-generated method stub
		ArrayList<Nacionalidad> listaNac = new ArrayList<Nacionalidad>();
		conectarBase();
		consultarBase("select * from nacionalidad");
		try {
			while (resultado.next()) {
				Nacionalidad Nac = new Nacionalidad();
				Nac.setId(resultado.getLong("idNacionalidad"));
				Nac.setDescripcion(resultado.getString("Descripcion"));
				listaNac.add(Nac);
			}
			desconectarBase();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return listaNac;
	}

	@Override
	public ArrayList<Provincia> listarProvincia() {
		// TODO Auto-generated method stub
		ArrayList<Provincia> listaProv = new ArrayList<Provincia>();
		conectarBase();
		consultarBase("select * from provincia");
		try {
			while (resultado.next()) {
				Provincia prov = new Provincia();
				prov.setId(resultado.getLong("idProvincia"));
				prov.setDescripcion(resultado.getString("Descripcion"));
				listaProv.add(prov);
			}
			desconectarBase();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return listaProv;
	}

	public ArrayList<TipoUsuario> listarTipoUsuarios() {
		ArrayList<TipoUsuario> listaTipUs = new ArrayList<TipoUsuario>();
		conectarBase();
		consultarBase("select * from tipousuario");

		try {
			while (resultado.next()) {
				TipoUsuario tipUs = new TipoUsuario();
				tipUs.setId(resultado.getLong("idTipoUsuario"));
				tipUs.setDescripcion(resultado.getString("Descripcion"));
				listaTipUs.add(tipUs);
			}
			desconectarBase();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return listaTipUs;
	}

	@Override
	public Cliente buscarCliente(Long id) {
		Cliente cli = null;
		String sql = "Select Nombre, Apellido, idCliente, Usuario, DNI, CUIL, Mail,Estado FROM cliente WHERE idCliente = "
				+ id + ";";
		try {
			consultarBase(sql);
			while (resultado.next()) {
				cli = new Cliente();
				cli.setApellido(resultado.getString(1));
				cli.setNombre(resultado.getString(2));
				cli.setId(resultado.getLong(3));
				cli.setUsuario(resultado.getString(4));
				cli.setDni(resultado.getLong(5));
				cli.setCuil(resultado.getLong(6));
				cli.setMail(resultado.getString(7));
				cli.setEstado(resultado.getBoolean(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cli;
	}

	@Override
	public Cliente buscarClientePorUsuario(String usuario) {
		Cliente cliente = null;
		Nacionalidad nac = new Nacionalidad();
		Localidad loc = new Localidad();
		Provincia prov = new Provincia();
		String sql = "Select * FROM cliente WHERE Usuario='" + usuario + "';";
		try {
			System.out.println("ENTRE");
			consultarBase(sql);
			while (resultado.next()) {
				cliente = new Cliente();
				cliente.setId(resultado.getLong("idCliente"));
				cliente.setDni(resultado.getLong("DNI"));
				cliente.setCuil(resultado.getLong("CUIL"));
				cliente.setUsuario(resultado.getString("Usuario"));
				cliente.setContrasenia(resultado.getString("Contrasenia"));
				cliente.setNombre(resultado.getString("Nombre"));
				cliente.setApellido(resultado.getString("Apellido"));
				cliente.setSexo(resultado.getString("Sexo"));
				nac.setId(resultado.getLong("idNacionalidad"));
				cliente.setNacionalidad(nac);
				cliente.setFechaNac(resultado.getDate("FechaNacimiento"));
				loc.setId(resultado.getLong("idLocalidad"));
				cliente.setLocalidad(loc);
				prov.setId(resultado.getLong("idProvincia"));
				cliente.setProvincia(prov);
				cliente.setDireccion(resultado.getString("Direccion"));
				cliente.setMail(resultado.getString("Mail"));
				cliente.setEstado(resultado.getBoolean("Estado"));
				System.out.println("CLIENTE ESTADO CLIENTEDAO: " + cliente);
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			e.printStackTrace();
			return cliente;
		}
		return cliente;
	}

	public TipoUsuario buscarTipoUsuarioPorId(Long idTipoUsuario) {

		TipoUsuario tipoUsuario = null;
		String consulta = "Select * from TipoUsuario where idTipoUsuario= " + idTipoUsuario + ";";
		try {
			consultarBase(consulta);
			while (resultado.next()) {
				tipoUsuario = new TipoUsuario();
				tipoUsuario.setId(resultado.getLong(1));
				tipoUsuario.setDescripcion(resultado.getString(2));
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			e.printStackTrace();
			return tipoUsuario;
		}

		return tipoUsuario;
	}

	@Override
	public ArrayList<Prestamo> listarPrestamos(java.sql.Date inicio, java.sql.Date fin) {
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		conectarBase();
		consultarBase(
				"select IDPrestamo, IdCliente , MontoPrestado ,montoAdeudado from prestamoxcliente WHERE estado =1 and aprobacion =1 and fecha between '"
						+ inicio + "' and '" + fin + "';");

		try {
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getLong("IDPrestamo"));
				prestamo.setIdCliente(resultado.getLong("IdCliente"));
				prestamo.setMontoPrestado(resultado.getDouble("MontoPrestado"));
				prestamo.setMontoAdeudado(resultado.getDouble("montoAdeudado"));
				listaPrestamos.add(prestamo);
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			listaPrestamos = null;
		} finally {

		}
		return listaPrestamos;
	}

	@Override
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{call Cliente(?,?)}");
			conectarBase(); // inicio conexion con base de datos

			ps = conexion.prepareCall(sb.toString());
			ps.setString(1, "ListarClientes");
			ps.setLong(2, 0);
			consultarBasePS(); // ejecuto el PreparedStatement: resultado=ps.executeQuery();

			while (resultado.next()) {
				Cliente cliente = new Cliente();
				Nacionalidad nac = new Nacionalidad();
				Localidad loc = new Localidad();
				Provincia prov = new Provincia();
				cliente.setId(resultado.getLong("idCliente"));
				cliente.setDni(resultado.getLong("DNI"));
				cliente.setCuil(resultado.getLong("CUIL"));
				cliente.setUsuario(resultado.getString("Usuario"));
				cliente.setContrasenia(resultado.getString("Contrasenia"));
				cliente.setNombre(resultado.getString("Nombre"));
				cliente.setApellido(resultado.getString("Apellido"));
				cliente.setSexo(resultado.getString("Sexo"));
				nac.setDescripcion(resultado.getString("DescripcionNac"));
				nac.setId(resultado.getLong("idNacionalidad"));
				cliente.setNacionalidad(nac);
				cliente.setFechaNac(resultado.getDate("FechaNacimiento"));
				loc.setDescripcion(resultado.getString("DescripcionLoc"));
				loc.setId(resultado.getLong("idLocalidad"));
				cliente.setLocalidad(loc);
				prov.setDescripcion(resultado.getString("DescripcionProv"));
				prov.setId(resultado.getLong("idProvincia"));
				cliente.setProvincia(prov);
				cliente.setDireccion(resultado.getString("Direccion"));
				cliente.setMail(resultado.getString("Mail"));
				cliente.setEstado(resultado.getBoolean("Estado"));
				listaClientes.add(cliente);

			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			listaClientes = null;
		} finally {

		}
		return listaClientes;
	}

	@Override
	public boolean agregarPrestamo(Prestamo prestamo) {
		System.out.println(prestamo);
		int filas = 0;
		try {
			String sql = "INSERT INTO prestamoxcliente(IDCliente, NumeroCuenta, CBU, Fecha, PlazoDePago, MontoAdeudado,"
					+ " MontoPrestado, CuotaMensual, CantCuotas, Estado, Aprobacion)" + "values ("
					+ prestamo.getIdCliente() + ", " + prestamo.getNroCuenta() + ", " + prestamo.getCbu() + ",'"
					+ prestamo.getFechaInicio() + "'," +prestamo.getCantCuotas()+","+ prestamo.getMontoAdeudado() + "," + prestamo.getMontoPrestado()
					+ ", " + prestamo.getCuotaMensual() + "," + prestamo.getCantCuotas() + "," + prestamo.getEstado()
					+ "," + prestamo.getAprobacion() + ");";

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

	public boolean AceptarPrestamos(Long idPrestamo) { /// Para el admin

		int filas = 0;

		try {
			String query = "UPDATE prestamoxcliente inner join cuentaxcliente on prestamoxcliente.CBU=cuentaxcliente.Cbu "
					+ "set prestamoxcliente.Aprobacion=true, cuentaxcliente.Saldo=cuentaxcliente.Saldo + prestamoxcliente.MontoPrestado "
					+ "WHERE prestamoxcliente.IDPrestamo=" + idPrestamo;
			
			filas = insertarModificarEliminar(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			desconectarBase();
		}
		return filas > 0;
	}

	@Override
	public boolean DesaprobarPrestamo(Long id) {
		
		int filas = 0;

		try {
			String query = "UPDATE prestamoxcliente SET Estado = False WHERE IDPrestamo=" + id;
			filas = insertarModificarEliminar(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			desconectarBase();
		}
		return filas >0;
	}

	@Override
	public ArrayList<Prestamo> listarPrestamos() {
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		conectarBase();
		consultarBase(
				"select IDPrestamo, IDCliente , MontoPrestado, MontoAdeudado, CBU, CantCuotas from prestamoxcliente WHERE estado =1 AND Aprobacion =0");

		try {
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getLong("IDPrestamo"));
				prestamo.setIdCliente(resultado.getLong("IdCliente"));
				prestamo.setMontoPrestado(resultado.getDouble("MontoPrestado"));
				prestamo.setMontoAdeudado(resultado.getDouble("montoAdeudado"));
				prestamo.setCbu(resultado.getLong("CBU"));
				prestamo.setCantCuotas(resultado.getInt("CantCuotas"));
				listaPrestamos.add(prestamo);
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			listaPrestamos = null;
		} finally {

		}
		return listaPrestamos;
	}
	
	
	
	public ArrayList<Prestamo> listarPrestamosCBU(Long CBU) {
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		conectarBase();
		consultarBase(
				"select IDPrestamo, IDCliente , MontoPrestado, MontoAdeudado, CBU, CantCuotas, Fecha,"
				+ " CuotaMensual, CuotaPaga from prestamoxcliente "
				+ "WHERE CuotaPaga<CantCuotas AND estado =1 AND CBU =" + CBU);

		try {
			while (resultado.next()) {
				Prestamo prestamo = new Prestamo();
				prestamo.setIdPrestamo(resultado.getLong("IDPrestamo"));
				prestamo.setIdCliente(resultado.getLong("IdCliente"));
				prestamo.setMontoPrestado(resultado.getDouble("MontoPrestado"));
				prestamo.setMontoAdeudado(resultado.getDouble("montoAdeudado"));
				prestamo.setCbu(resultado.getLong("CBU"));
				prestamo.setCantCuotas(resultado.getInt("CantCuotas"));
				prestamo.setFechaInicio(resultado.getDate("Fecha"));
				prestamo.setCuotapaga(resultado.getInt("CuotaPaga"));
				prestamo.setCuotaMensual(resultado.getDouble("CuotaMensual"));
				listaPrestamos.add(prestamo);
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			listaPrestamos = null;
		} finally {

		}
		System.out.println();
		return listaPrestamos;
	}
	
	

	@Override
	public boolean listarPrestamoPorId(int id) {
		conectarBase();

		String query = "select IDPrestamo, IdCliente , MontoPrestado ,MontoAdecuado from prestamoxcliente WHERE estado =1 and IDPrstamo="
				+ id;
		PreparedStatement st = null;
		boolean estado = true;

		try {
			estado = st.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			desconectarBase();
		}
		return estado;
	}

	@Override
	public boolean InjectarPrestamo(double monto, Long cbu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pagarCuotaPrestamo(Long IDPrestamo) {
		
		int filas = 0;
	
		try {
			
			String query = "Update prestamoxcliente inner join cuentaxcliente on prestamoxcliente.CBU = "
					+ "cuentaxcliente.Cbu set prestamoxcliente.CuotaPaga=prestamoxcliente.CuotaPaga+1, "
					+ "cuentaxcliente.Saldo=cuentaxcliente.Saldo-prestamoxcliente.CuotaMensual WHERE prestamoxcliente.IDPrestamo = "+IDPrestamo ;
			
			filas = insertarModificarEliminar(query);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			desconectarBase();
		}
		return filas>0;
		
				
	}
}
