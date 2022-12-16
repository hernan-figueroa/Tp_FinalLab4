package negocioImpl;

import java.util.ArrayList;

import daoImpl.CuentaDaoImpl;
import entidades.Cuenta;
import entidades.TipoCuenta;
import negocio.CuentaNegocio;

public class CuentaNegocioImpl implements CuentaNegocio{
	
	private CuentaDaoImpl cuentaDao = new CuentaDaoImpl();
	
	@Override
	public ArrayList<TipoCuenta> listarTipoCuenta() {
		return cuentaDao.listarTipoCuenta();
	}
	@Override
	public Long generarNroCuenta(Long id) {
		return cuentaDao.generarNroCuenta(id);
	}
	@Override
	public TipoCuenta buscarTipoCuentaPorId(Long idTipoCuenta) {

		return cuentaDao.buscarTipoCuentaPorId(idTipoCuenta);
	}
	@Override
	public boolean addCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return cuentaDao.addCuenta(cuenta);
	}
	@Override
	public Cuenta buscarCuentaPorId(Long id_cliente, Long numeroCuenta) {
		// TODO Auto-generated method stub
		return cuentaDao.buscarCuentaPorId(id_cliente,numeroCuenta) ;
	}

	@Override
	public boolean deleteCuenta(Long IDCliente, Long NumeroCuenta) {
		boolean estado = false;
		
		if(IDCliente > 0) {
			estado = cuentaDao.deleteCuenta(IDCliente, NumeroCuenta);
		}
		return estado;
	}
	@Override
	public ArrayList<Cuenta> listarCuenta(Long id) {
		// TODO Auto-generated method stub
		return cuentaDao.listarCuenta(id);
	}
	
	
	
	
	@Override

	public boolean checkCBU(String cbu) {

		return cuentaDao.CheckCBU(cbu);
	}
	
	
	@Override
	public boolean RealizarTransferencia(String OP, String CBUOrigen, String CBUDestino, String monto) {
		// TODO Auto-generated method stub
		return cuentaDao.RealizarTransferencia(OP, CBUOrigen, CBUDestino, monto);
	}
	
	@Override
	public boolean CheckSaldo(String CBUOrigen, double monto) {
		// TODO Auto-generated method stub
		return cuentaDao.CheckSaldo(CBUOrigen, monto);
	}
}
