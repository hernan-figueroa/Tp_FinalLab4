package negocio;

import java.util.ArrayList;

import entidades.Login;

public interface LoginNegocio {
	public ArrayList<Login> VerificarLogin(Long DNI,String Usuario,String Clave);
}
