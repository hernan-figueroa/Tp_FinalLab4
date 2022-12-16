package entidades;

import java.sql.Date;

public class Movimiento {

	private Long idCliente;
	private Long CBU;
	private Date Fecha;
	private String detalle;
	private double importe;
	private TipoMovimiento TipoMovimiento;
	private boolean estado;

	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getCBU() {
		return CBU;
	}
	public void setCBU(Long cBU) {
		CBU = cBU;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	public TipoMovimiento getTipoMovimiento() {
		return TipoMovimiento;
	}
	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Movimiento [idCliente=" + idCliente + ", CBU=" + CBU + ", Fecha=" + Fecha + ", detalle=" + detalle
				+ ", importe=" + importe + ", idTipoMovimiento=" + TipoMovimiento + ", estado=" + estado + "]";
	}
	
	
}
