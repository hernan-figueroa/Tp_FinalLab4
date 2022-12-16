package negocio;

import java.util.ArrayList;

import entidades.Login;

public interface LoginNegocio {
	public Login VerificarLogin(String OP,String Usuario,String Clave,String Mail);
}
