package clasesPropias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import clasesComunes.Usuario_comp;
/**
 * 	Carga para la capa de dominio el acceso a los ficheros que estan relacionados con la clase Usuario
 *	
 *	@author Grup 45 Sudoku
 *	@version 1.0
 *	@since 14-11-2015
 */
public class ControladorUsuario {
	private Scanner s;
	private ControladorFicheros cf;
	/**
	 * 	Constructora con parametro
	 * 
	 * 	@param	u	Usuario asignado con el cual queremos trabajar
	 * 	@see Usuario_comp
	 * 	@throws	IOException Si ocurre un problema con la lectura/escritura del fichero
	 */
	ControladorUsuario(Usuario_comp u) throws IOException{
		s= new Scanner(System.in);
		cf= new ControladorFicheros();
		System.out.println("MENU USUARIO");
		System.out.println("1.- Crear Usuario");
		System.out.println("2.- LogIn");
		 switch (s.nextInt()) {
	        case 1:
	        		 CrearUsuario(u);
	                 break;
	        case 2:
	        		 LogIN(u);
	                 break;
			}
	}
	/**
	 * 	A&ntilde;ade un usuario a la lista de usuarios existentes
	 * 
	 * 	@param	u	Usuario que crearemos
	 * 	@see Usuario_comp
	 * 	@throws	IOException	Si ocurre un problema con la lectura/escritura del fichero
	 * 	@throws	FileNotFoundException Si el fichero no existe devolvera un error
	 */
	public void CrearUsuario(Usuario_comp u) throws FileNotFoundException, IOException{
		System.out.println("Menu Creacion Usuario");
		cf.CrearUsuario_i(u);
		LogIN(u);
	}
	/**
	 * 	Inicia el proceso de inicio de sesion
	 * 
	 * 	@param	u	Usuario con el cual queremos realizar un login
	 * 	@throws	FileNotFoundException	Si ocurre un problema con la lectura/escritura del fichero
	 */
	public void LogIN(Usuario_comp u) throws FileNotFoundException{
		System.out.println("Menu LogIn");
		cf.LogIN1(u);
	}
	
	
	
}
