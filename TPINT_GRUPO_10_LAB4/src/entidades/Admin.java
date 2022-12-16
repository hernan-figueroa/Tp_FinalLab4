package entidades;

public class Admin extends Usuario {

	private boolean superAdmin;

	public Admin() {
		super();
	}

	public Admin(boolean superAdmin, String usuario, String contrasenia, TipoUsuario tipoUsuario,String mail) {
		super(usuario, contrasenia, tipoUsuario,mail);
		this.superAdmin = superAdmin;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	@Override
	public String toString() {
		return "Admin [superAdmin=" + superAdmin + ", usuario=" + usuario + ", contrasenia=" + contrasenia
				+ ", tipoUsuario=" + tipoUsuario + ", estado=" + estado + "]";
	}

	

}
