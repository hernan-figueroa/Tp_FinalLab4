package entidades;

import java.util.Date;

public class Cliente {
	
	public Long id;
	public Long dni;
	public Long cuil;
	public String nombre;
	public String apellido;
	public String sexo;
	public Nacionalidad nacionalidad;
	public Date fechaNac;
	public String direccion;
	public Localidad localidad;
	public Provincia provincia;
	public String mail;
	public Usuario usuario;
	public Boolean estado;
	
	public Cliente() {
	}

	public Cliente(Long idCliente, Long dni, Long cuil, String nombre, String apellido, String sexo,
			Nacionalidad nacionalidad, Date fechaNac, String direccion, Localidad localidad, Provincia provincia,
			String mail, Usuario usuario, Boolean estado) {
		this.id = idCliente;
		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.fechaNac = fechaNac;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.mail = mail;
		this.usuario = usuario;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idCliente) {
		this.id = idCliente;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", cuil=" + cuil + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad + ", fechaNac="
				+ fechaNac + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", mail=" + mail + ", usuario=" + usuario + ", estado=" + estado + "]";
	}
	
	

}
