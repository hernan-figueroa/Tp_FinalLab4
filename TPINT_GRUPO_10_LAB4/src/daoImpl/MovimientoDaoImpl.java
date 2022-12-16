package daoImpl;

import dao.MovimientoDao;
import entidades.Movimiento;
import entidades.TipoMovimiento;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Dao;

public class MovimientoDaoImpl extends Dao implements MovimientoDao{

	@Override
	public boolean addMovimiento(Movimiento mov, String detalle) {
		
		int filas = 0;
		
		try {
			
			String sql = "INSERT INTO movimiento (idCliente, CBU, Fecha, Detalle, Importe, IDTipoDeMovimiento, Estado)" 
					+ "values ('" + mov.getIdCliente() + "','" + mov.getCBU() +"','"+ mov.getFecha() +"','" + detalle +"','"
					 + mov.getImporte() + "', '"+ mov.getTipoMovimiento().getId() +"' , true);";
			
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
	public Long buscarClientePorCBU(String CBU) {
		
		Long idCliente = 0L;
		
		conectarBase();
		consultarBase("select idCliente from cuentaxcliente where Cbu = " + CBU + ";");
		
		try{
			while(resultado.next()){
				idCliente = resultado.getLong(1);
			}
			desconectarBase();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		
		}
		return idCliente;
	}
	
	public ArrayList<Movimiento> listarMovimientos(String CBU) {
		ArrayList<Movimiento> listMov = new ArrayList<>();
		String consulta = "select * from movimiento as m inner join tipomovimiento "+
		"as T on T.idTipoMovimiento=m.IDTipoDeMovimiento where estado=1 and cbu ="+CBU+" ;";
		consultarBase(consulta);
		Movimiento mov;
		try {
			while(resultado.next()) {
				mov = new Movimiento();
				TipoMovimiento Tipmov = new TipoMovimiento();
				mov.setIdCliente(resultado.getLong(2));
				mov.setCBU(resultado.getLong(3));
				mov.setFecha(resultado.getDate(4));
				mov.setDetalle(resultado.getString(5));
				mov.setImporte(resultado.getDouble(6));
				Tipmov.setDescripcion(resultado.getString(10));
		        Tipmov.setId(resultado.getLong(7));
		        mov.setTipoMovimiento(Tipmov);
				mov.setEstado(resultado.getBoolean(8));
				
				listMov.add(mov);
			}
			desconectarBase();
		} catch (SQLException e) {
			desconectarBase();
			e.printStackTrace();}
			
		return listMov;
	}

}
