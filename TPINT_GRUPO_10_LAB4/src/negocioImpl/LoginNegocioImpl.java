package negocioImpl;

import java.util.ArrayList;

import daoImpl.ClienteDaoImpl;
import entidades.Login;
import negocio.LoginNegocio;

public class LoginNegocioImpl implements LoginNegocio {
	ClienteDaoImpl logDao= new ClienteDaoImpl();
	
	@Override
	public Login VerificarLogin(String OP,String Usuario,String Clave,String Mail){
		Login UsuarioIngresado= new Login();
		UsuarioIngresado=logDao.VerificarLogin(OP,Usuario,Clave,Mail);
		return UsuarioIngresado;
	}
	
}
