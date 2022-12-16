package negocio;

import java.util.ArrayList;

import entidades.Movimiento;

public interface MovimientoNegocio {

	public boolean addMovimiento(Movimiento mov, String detalle);
	
	public Long buscarClientePorCBU(String CBU);
	
	public ArrayList<Movimiento> listarMovimientos(String CBU);
	
}
