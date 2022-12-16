package entidades;

import java.sql.Date;

public class Cuenta {
	
	private Long id_cliente;
	private Long numeroCuenta;
	private Long cbu;
	private TipoCuenta tipoCuenta;
	private Date fechaCreacion;
	private Double saldo;
	private Boolean estado = true;
		
	public Cuenta() {
	}

	public Cuenta(Long id_cliente, Long numeroCuenta, Long cbu, TipoCuenta tipoCuenta, Date fechaCreacion, Double saldo) {
		this.id_cliente = id_cliente;
		this.numeroCuenta = numeroCuenta;
		this.cbu = cbu;
		this.tipoCuenta = tipoCuenta;
		this.fechaCreacion = fechaCreacion;
		this.saldo = saldo;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Long getCbu() {
		return cbu;
	}

	public void setCbu(Long cbu) {
		this.cbu = cbu;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [id_cliente=" + id_cliente + ", numeroCuenta=" + numeroCuenta + ", cbu=" + cbu + ", tipoCuenta="
				+ tipoCuenta + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", estado=" + estado + "]";
	}
	
	
}
