package dao;

import java.util.ArrayList;

import entidades.Cuenta;
import entidades.TipoCuenta;

public interface CuentaDao {
	public boolean addCuenta(Cuenta cuenta);

	public boolean updateCuenta(String usuario, String clave , Integer tipoUsuario);

	public boolean deleteCuenta(Long id, Long numCuenta);

	public ArrayList<TipoCuenta> listarTipoCuenta();
	
	public ArrayList<Cuenta> listarCuenta(Long id);
	
	public Long generarNroCuenta(Long id);

	public TipoCuenta buscarTipoCuentaPorId(Long idTipoCuenta);

	public Cuenta buscarCuentaPorId(Long id_cliente, Long numeroCuenta);
	
	public boolean CheckCBU(String cbu);
	
	public boolean RealizarTransferencia (String OP, String CBUOrigen, String CBUDestino, String monto);
	
	public boolean CheckSaldo (String CBUOrigen, double monto);
}
