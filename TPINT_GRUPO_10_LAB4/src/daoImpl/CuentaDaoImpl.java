package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import dao.CuentaDao;
import dao.Dao;
import entidades.Cuenta;
import entidades.TipoCuenta;

public class CuentaDaoImpl extends Dao implements CuentaDao {

	@Override
	public boolean addCuenta(Cuenta cuenta) {
		int filas = 0;
		System.out.println("ASDASD"+cuenta.getFechaCreacion());
		try {
			
			String sql = "INSERT INTO Cuentaxcliente(idCliente, NumeroCuenta,FechaCreacion,IdTipoCuenta,saldo, estado, cbu)" 
					+ "values (" + cuenta.getId_cliente() + "," + cuenta.getNumeroCuenta() +",'"+cuenta.getFechaCreacion() +"'," + cuenta.getTipoCuenta().getId() +","
					 +cuenta.getSaldo()+ "," + cuenta.getEstado()+ ","+ cuenta.getCbu() +");";
			
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
	public boolean updateCuenta(String usuario, String clave, Integer tipoUsuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCuenta(Long id, Long numCuenta) {
		int filas=0;
		try {
			String sql = "Update cuentaxcliente SET estado = 0 WHERE IDCliente = " + id + " AND NumeroCuenta = "+ numCuenta +";";
			filas = insertarModificarEliminar(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas>0;
	}

	@Override
	public ArrayList<TipoCuenta> listarTipoCuenta() {
		ArrayList<TipoCuenta> tiposCuentas = new ArrayList<>();
		String consulta = "Select * from TipoCuentas";
		consultarBase(consulta);
		TipoCuenta tipoCuenta;
		try {
			while(resultado.next()) {
				tipoCuenta = new TipoCuenta();
				tipoCuenta.setId(resultado.getLong(1));
				tipoCuenta.setDescripcion(resultado.getString(2));
				tiposCuentas.add(tipoCuenta);
			}
			desconectarBase();
		} catch (SQLException e) {
			desconectarBase();
			e.printStackTrace();
		}
		
		return tiposCuentas;
	}
	@Override
	public Long generarNroCuenta(Long id) {
		Long nroCuenta = 1L;
		String consulta = "Select MAX(NumeroCuenta) from cuentaxcliente;";
		try {
			consultarBase(consulta);
			while (resultado.next()) {
				nroCuenta= resultado.getLong(1) +1L;
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			e.printStackTrace();
			return nroCuenta;
		}
		
		return nroCuenta;
	}
	@Override
	public TipoCuenta buscarTipoCuentaPorId(Long idTipoCuenta) {
		
		TipoCuenta tipoCuenta=null;
		String consulta = "Select * from TipoCuentas where idTipoCuentas= " + idTipoCuenta+";";
		try {
			consultarBase(consulta);
			while (resultado.next()) {
				tipoCuenta = new TipoCuenta();
				tipoCuenta.setId(resultado.getLong(1));
				tipoCuenta.setDescripcion(resultado.getString(2));
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			e.printStackTrace();
			return tipoCuenta;
		}
		
		return tipoCuenta;
	}
	@Override
	public Cuenta buscarCuentaPorId(Long id_cliente, Long numeroCuenta) {
		Cuenta cuenta=null;
		String consulta = "Select * from cuentaxcliente where idCliente= " + id_cliente+" and numeroCuenta = "+ numeroCuenta+";";
		try {
			consultarBase(consulta);
			while (resultado.next()) {
				cuenta = new Cuenta();
				cuenta.setId_cliente(resultado.getLong(1));
				cuenta.setNumeroCuenta(resultado.getLong(2));
				cuenta.setFechaCreacion(resultado.getDate(4));
				cuenta.setSaldo(resultado.getDouble(5));
				cuenta.setEstado(resultado.getBoolean(6));
				cuenta.setCbu(resultado.getLong(7));
				cuenta.setTipoCuenta(buscarTipoCuentaPorId(resultado.getLong(3)));
			}
			desconectarBase();
		} catch (Exception e) {
			desconectarBase();
			return cuenta;
		}
		
		return cuenta;
	}
	@Override
	public ArrayList<Cuenta> listarCuenta(Long id) {
		ArrayList<Cuenta> Cuentas = new ArrayList<>();
		String consulta = "Select * from cuentaxcliente WHERE estado=1 and IdCliente="+id+" ;";
		consultarBase(consulta);
		Cuenta cuenta;
		try {
			while(resultado.next()) {
				cuenta = new Cuenta();
				cuenta.setId_cliente(resultado.getLong(1));
				cuenta.setNumeroCuenta(resultado.getLong(2));
				TipoCuenta tipoCuenta = new TipoCuenta();
				tipoCuenta.setId(resultado.getLong(3));
				cuenta.setTipoCuenta(tipoCuenta);
				cuenta.setSaldo(resultado.getDouble(5));
				cuenta.setCbu(resultado.getLong(7));
				
				Cuentas.add(cuenta);
			}
			desconectarBase();
		} catch (SQLException e) {
			desconectarBase();
			e.printStackTrace();
		}
		
		return Cuentas;
	}

	@Override
	public boolean CheckCBU(String cbu) {
		
		boolean estado = false;
		
		String consulta = "Select * from cuentaxcliente WHERE estado=1 and Cbu="+cbu+" ;";
		consultarBase(consulta);

		int cont=0;
		
		try {
			while(resultado.next()) {
				cont++;
			}
			desconectarBase();
		} catch (SQLException e) {
			desconectarBase();
			e.printStackTrace();
		}
		
		if(cont==1) {
			estado=true;
		}
		 
		return estado;
	}

	
	
	@Override
	public boolean RealizarTransferencia(String OP, String CBUOrigen, String CBUDestino, String monto) {
		
		boolean estadoT = false;
		
		int cont = 0;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("{call Transferencia(?,?,?,?)}");
			conectarBase(); // inicio conexion con base de datos

			ps = conexion.prepareCall(sb.toString());
			ps.setString(1, OP);
			ps.setString(2, CBUOrigen);
			ps.setString(3, CBUDestino);
			ps.setString(4, monto);
			consultarBasePS(); // ejecuto el PreparedStatement: resultado=ps.executeQuery();

			cont = 1;
		
			ps.close();
			desconectarBase();
		} catch (SQLException e) {
			e.printStackTrace();
			desconectarBase();
		}
		if(cont == 1) {
			estadoT = true;
		}
		return estadoT;
	}

	
	@Override
	public boolean CheckSaldo(String CBUOrigen, double monto) {
		
		boolean estado = false;
		
		String consulta = "Select Saldo from cuentaxcliente WHERE Cbu="+CBUOrigen+" ;";
		consultarBase(consulta);
		
		double Saldo = 0;
		
		try {
			while(resultado.next()) {
				Saldo = resultado.getDouble(1);
			}
			desconectarBase();
		} catch (SQLException e) {
			desconectarBase();
			e.printStackTrace();
		}
		
		if(Saldo > monto) {
			estado = true;
		}
		 
		return estado;
	}
	
	
}
