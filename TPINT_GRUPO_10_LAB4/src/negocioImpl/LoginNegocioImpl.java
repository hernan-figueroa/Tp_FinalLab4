package negocioImpl;

import java.util.ArrayList;

import daoImpl.ClienteDaoImpl;
import entidades.Login;
import negocio.LoginNegocio;

public class LoginNegocioImpl implements LoginNegocio {
	ClienteDaoImpl logDao= new ClienteDaoImpl();
	
	@Override
	public Login VerificarLogin(Long DNI,String Usuario,String Clave){
		System.out.print("LLEGO A VERIFICAR LOGIN");
		Login UsuarioIngresado= new Login();
		UsuarioIngresado=logDao.VerificarLogin(DNI,Usuario,Clave);
		return UsuarioIngresado;
	}
	
}
