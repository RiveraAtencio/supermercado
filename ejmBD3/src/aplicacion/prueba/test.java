package aplicacion.prueba;

import aplicacion.conexion.accesoDatos;

public class test 
{
public static void main(String[]args)
{
	accesoDatos ad=new accesoDatos();
	ad.abrirConexion();
	ad.obtenerDatosTabla();
	ad.mostrarDatosAutor();
	
	
	//elimiar registro
	//ad.borrarRegistro(5);
	
	//ad.insertar1(5, "julio", "venezuela");
	ad.insertar2(6, "julio", "venezuela");
}

	
	
	
	
}
