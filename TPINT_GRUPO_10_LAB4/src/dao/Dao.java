package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {

	protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    protected PreparedStatement ps= null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tp_final";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBase(){
        
        try {
            Class.forName(DRIVER);
            
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/"+DATABASE +"?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);            
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    protected void desconectarBase(){
        try {
            if (conexion != null) {
                conexion.close();
            }
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
                        
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    protected int insertarModificarEliminar(String sql) {
        int filas=0;
    	try {
            conectarBase();
            sentencia = conexion.createStatement();
            filas = sentencia.executeUpdate(sql);
            
        } catch (Exception e) {
        	e.printStackTrace();
        }finally{
            desconectarBase();  
        }
    	return filas;
    }
    
    protected void consultarBase(String sql){
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);    
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
    
    protected void consultarBasePS(){
        try {
        	resultado=ps.executeQuery();  
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

