package entidades;

public class Admin extends Usuario{

	private boolean superAdmin;
	
	public Admin() {
		super();
	}
	
	public Admin(boolean superAdmin, String usuario, String contrasenia, int tipoUsuario){
		super(usuario, contrasenia, tipoUsuario);
		this.superAdmin = superAdmin;
	}

	public boolean isSuperAdmin() {
		return superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}
	
	
}
