package dao;

import java.util.ArrayList;

import entidades.Movimiento;

public interface MovimientoDao {

	public boolean addMovimiento(Movimiento mov, String detalle);
	public Long buscarClientePorCBU(String CBU);
	
	public ArrayList<Movimiento> listarMovimientos(String CBU);
}
