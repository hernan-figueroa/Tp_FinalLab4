package negocioImpl;

import java.util.ArrayList;

import dao.MovimientoDao;
import daoImpl.MovimientoDaoImpl;
import entidades.Movimiento;
import negocio.MovimientoNegocio;

public class MovimientoNegocioImpl implements MovimientoNegocio {

	MovimientoDao movDao = new MovimientoDaoImpl();
	
	@Override
	public boolean addMovimiento(Movimiento mov, String detalle) {
		// TODO Auto-generated method stub
		return movDao.addMovimiento(mov, detalle);
	}

	@Override
	public Long buscarClientePorCBU(String CBU) {
		// TODO Auto-generated method stub
		return movDao.buscarClientePorCBU(CBU);
	}

	public ArrayList<Movimiento> listarMovimientos(String CBU) {
		return movDao.listarMovimientos(CBU);
	}
}
