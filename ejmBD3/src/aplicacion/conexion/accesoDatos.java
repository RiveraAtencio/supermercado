package aplicacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class accesoDatos {
Connection con;
Statement st;
ResultSet rs;
	
public void abrirConexion()
{
	try {
	
	String url="jdbc:mysql://localhost/Biblioteca";	
	String userName="root";
	 String password="";

	 Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url,userName,password);
	 System.out.println("Conexion ok");
	
} 
catch (Exception e) {
	 System.out.println("error Conexion");
}
}


public void cerrarConexion()

{try {con.close();
System.out.println("Conexion cerrada a la BD");
	
} catch (Exception e) {
	System.out.println("Error  al cerrar la conexion ");
}

	}


public void  obtenerDatosTabla()
{try {st=con.createStatement();
	rs=st.executeQuery("SELECT*FROM AUTOR");
	System.out.println("La tabla esta abierta");
} catch (Exception e) {
	e.printStackTrace();
}
	
	
}


public void mostrarDatosAutor()
{
try {
	while(rs.next())
	{int cod =rs.getInt("IdAutor");
	String nom=rs.getString("Nombre");
	String nacion=rs.getString("Nacionalidad");
	System.out.println(cod+"\t"+nom+"\t"+nacion);
	
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public void borrarRegistro(int n){
	
	try {
		Statement st2=con.createStatement();
		st2.executeUpdate("delete from autor where idAutor="+n);
		 System.out.println("Registro eliminado");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void insertar1(int id, String nom, String nacion)
{
try {
		Statement st1=con.createStatement();
	st1.executeUpdate
	("insert into autor (idautor,nombre,nacionalidad)values("+id+",' "+nom+"','"+nacion+"')'");
	 System.out.println("Registro insertado");

} catch (Exception e) {


	e.printStackTrace();
	


}}


public void insertar2(int id, String nom, String nacion)
{
try {
		PreparedStatement ps=con.prepareStatement
	
	("insert into autor (idautor,nombre,nacionalidad)values(?,?,?)");
		
		ps.setInt(1,id);
		ps.setString(2, nom);
		ps.setString(3, nacion);
		
		if(ps.executeUpdate()!=1)
			throw new Exception("Error al insertar rgisttro");
	 System.out.println("Registro insertado");

} catch (Exception e) {


	e.printStackTrace();
	


}}

}
	

