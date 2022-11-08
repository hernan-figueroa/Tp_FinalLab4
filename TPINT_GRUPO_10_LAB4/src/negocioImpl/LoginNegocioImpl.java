package negocioImpl;

import java.util.ArrayList;

import dao.LoginDao;
import entidades.Login;
import negocio.LoginNegocio;

public class LoginNegocioImpl implements LoginNegocio {
	LoginDao logDao= new LoginDao();
	
	@Override
	public ArrayList<Login> VerificarLogin(Long DNI,String Usuario,String Clave){
		System.out.print("LLEGO A VERIFICAR LOGIN");
		ArrayList<Login>UsuarioIngresado= new ArrayList<Login>();
		UsuarioIngresado=logDao.VerificarLogin(DNI,Usuario,Clave);
		return UsuarioIngresado;
	}
	
}
