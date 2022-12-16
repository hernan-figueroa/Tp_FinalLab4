package entidades;

public class Usuario {
	
	protected String usuario;
	protected String contrasenia;
	protected TipoUsuario tipoUsuario;
	protected String mail;
	protected boolean estado = true;
	
	public Usuario() {
	}

	public Usuario(String usuario, String contrasenia, TipoUsuario tipoUsuario,String mail) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.tipoUsuario = tipoUsuario;
		this.mail=mail;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenia=" + contrasenia + ", tipoUsuario=" + tipoUsuario
				+ ", estado=" + estado + "]";
	}
	
	
}
