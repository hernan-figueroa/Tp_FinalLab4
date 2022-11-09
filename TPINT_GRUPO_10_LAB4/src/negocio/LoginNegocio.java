package negocio;

import java.util.ArrayList;

import entidades.Login;

public interface LoginNegocio {
	public Login VerificarLogin(Long DNI,String Usuario,String Clave);
}
