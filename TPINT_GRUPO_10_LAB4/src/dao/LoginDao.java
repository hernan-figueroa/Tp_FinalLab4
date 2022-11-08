package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Login;



public class LoginDao extends Dao {
	
	

    private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tp_final";
	

	 
	 
	 public ArrayList<Login> VerificarLogin(Long DNI,String Usuario,String Clave)
		{
	    	ArrayList<Login>usuario=new ArrayList<Login>();
			Connection cn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try{
				
				cn = DriverManager.getConnection(host+dbName, user,pass);
				Statement st = cn.createStatement();
				StringBuilder sb=new StringBuilder();
	    		sb.append("{call Login(?,?,?)}");
	    		ps=cn.prepareCall(sb.toString());
	    		ps.setLong(1,DNI);
	    		ps.setString(2,Usuario);
	    		ps.setString(3, Clave);
	    		resultado=ps.executeQuery();
	    		System.out.println("Antes de entrar a resultado");
	    		if(resultado.next()) {
	    			Login userLog= new Login();
	    			userLog.setDNI(resultado.getLong("DNI"));
	    			userLog.setUsuario(resultado.getString("usuario"));
	    			userLog.setClave(resultado.getString("Clave"));
	    			userLog.setAdmin(resultado.getString("TipoUsuario"));
	    			usuario.add(userLog);	    			
	    		}else ;
	    		
	    		ps.close();
	    		return usuario;
			}catch(Exception e){				
				return null;
			}finally{
				
			}
		}
	
}
