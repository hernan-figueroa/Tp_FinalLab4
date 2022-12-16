package negocio;

import java.util.ArrayList;

import entidades.Cuenta;
import entidades.TipoCuenta;

public interface CuentaNegocio {
	
	public ArrayList<TipoCuenta> listarTipoCuenta();

	public Long generarNroCuenta(Long id);

	public TipoCuenta buscarTipoCuentaPorId(Long idTipoCuenta);
	
	public boolean addCuenta(Cuenta cuenta);

	public Cuenta buscarCuentaPorId(Long id_cliente, Long numeroCuenta);
	
	public boolean deleteCuenta(Long IDCliente, Long NumeroCuenta);
	
	public ArrayList<Cuenta> listarCuenta(Long id);
	
	public boolean checkCBU(String cbu);
	
	public boolean RealizarTransferencia(String OP, String CBUOrigen, String CBUDestino, String monto);
	
	public boolean CheckSaldo (String CBUOrigen, double monto);
}
