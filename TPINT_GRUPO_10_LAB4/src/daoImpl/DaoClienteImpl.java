package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import dao.DaoCliente;
import entidades.Cliente;
import entidades.Login;


public class DaoClienteImpl implements DaoCliente  {
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String update = "UPDATE tp_final.cliente a inner join tp_final.usuario b on a.Usuario=b.Usuario SET a.idCliente=?, a.CUIL=?, a.Nombre=?, a.Apellido=?, a.Sexo=?, a.IDNacionalidad=?, a.FechaNacimiento=?, a.Direccion=?, a.IDLocalidad=?, a.IDProvincia=?, a.Mail=?, a.Estado=?, a.DNI=?,b.Contraseña=? WHERE a.idCliente=?";
	private static final String readall = "SELECT * FROM personas";

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "tp_final";
	Dao dao= new Dao();
	
	public boolean update(Cliente cliente)
	{
		
	
	dao.insertarModificarEliminar(update);
	return false;
	
	}
	
	
	
	
@Override
public boolean insert(Cliente cliente) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean delete(Cliente cliente_a_eliminar) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public List<Cliente> readAll() {
	// TODO Auto-generated method stub
	return null;
}
}