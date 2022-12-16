package entidades;

import java.sql.Date;

public class Prestamo {
	
	private Long idCliente;
	private Long nroCuenta;
	private Long idPrestamo;
	private TipoCuenta tipoCuenta;
	private Long cbu;
	private Date fechaInicio;
	private Date fechaFin;
	private Date plazoDePago;
	private Double montoAdeudado;
	private Double montoPrestado;
	private Double cuotaMensual;
	private Integer cantCoutas;
	private Boolean estado;
	private Boolean aprobacion;
	private int cuotapaga;
	
	public Prestamo() {
	}

	public Prestamo(Long idCliente, Long nroCuenta, Long idPrestamo, TipoCuenta tipoCuenta, Long cbu, Date fechaInicio, Date fechaFin, Date plazoDePago,
			Double montoAdeudado, Double montoPrestado, Double cuotaMensual, Integer cantCoutas, Boolean estado, Boolean aprobacion) {
		this.idCliente = idCliente;
		this.nroCuenta = nroCuenta;
		this.idPrestamo = idPrestamo;
		this.tipoCuenta = tipoCuenta;
		this.cbu = cbu;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.plazoDePago = plazoDePago;
		this.montoAdeudado = montoAdeudado;
		this.montoPrestado = montoPrestado;
		this.cuotaMensual = cuotaMensual;
		this.cantCoutas = cantCoutas;
		this.estado = estado;
		this.aprobacion = aprobacion;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Long nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Long getIdPrestamo() {
		return idPrestamo;
	}
	

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Long getCbu() {
		return cbu;
	}

	public void setCbu(Long cbu) {
		this.cbu = cbu;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getPlazoDePago() {
		return plazoDePago;
	}

	public void setPlazoDePago(Date plazoDePago) {
		this.plazoDePago = plazoDePago;
	}

	public Double getMontoAdeudado() {
		return montoAdeudado;
	}

	public void setMontoAdeudado(Double montoAdeudado) {
		this.montoAdeudado = montoAdeudado;
	}

	
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getMontoPrestado() {
		return montoPrestado;
	}

	public void setMontoPrestado(Double montoPrestado) {
		this.montoPrestado = montoPrestado;
	}

	public Double getCuotaMensual() {
		return cuotaMensual;
	}

	public void setCuotaMensual(Double cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}

	public Integer getCantCuotas() {
		return cantCoutas;
	}

	public void setCantCuotas(Integer cantCoutas) {
		this.cantCoutas = cantCoutas;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	public Boolean getAprobacion() {
		return aprobacion;
	}

	public void setAprobacion(Boolean aprobacion) {
		this.aprobacion = aprobacion;
	}

	@Override
	public String toString() {
		return "Prestamo [idCliente=" + idCliente + ", nroCuenta=" + nroCuenta + ", idPrestamo=" + idPrestamo + ", cbu="
				+ cbu + ", fechaInicio=" + fechaInicio + ", plazoDePago=" + plazoDePago + ", montoAdeudado="
				+ montoAdeudado + ", montoPrestado=" + montoPrestado + ", cuotaMensual=" + cuotaMensual
				+ ", cantCoutas=" + cantCoutas + ", estado=" + estado + "]";
	}

	public int getCuotapaga() {
		return cuotapaga;
	}

	public void setCuotapaga(int cuotapaga) {
		this.cuotapaga = cuotapaga;
	}
	
	
	
	

}
