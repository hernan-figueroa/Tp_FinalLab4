package entidades;

public class Login {
	private Long DNI;
	private String Usuario;
	private String Clave;
	private Boolean Admin;
	private String Mail;
	
	public Login(Long dNI, String usuario, String clave, Boolean admin,String mail) {
		super();
		DNI = dNI;
		Usuario = usuario;
		Clave = clave;
		Admin = admin;
		Mail=mail;
	}
	public Login() {
		
	}
	
	public Long getDNI() {
		return DNI;
	}
	public void setDNI(Long dNI) {
		DNI = dNI;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	@Override
	public String toString() {
		return "Login [DNI=" + DNI + ", Usuario=" + Usuario + ", Clave=" + Clave + ", Admin=" + Admin + ", Mail=" + Mail
				+ "]";
	}


	
}

