package entidades;

public class Usuario {
	
	public String usuario;
	public String contrasenia;
	public int tipoUsuario;
	
	public Usuario() {
	}

	public Usuario(String usuario, String contrasenia, int tipoUsuario) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.tipoUsuario = tipoUsuario;
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

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contrasenia=" + contrasenia + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
	
}
