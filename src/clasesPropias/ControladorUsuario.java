package clasesPropias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import clasesComunes.Usuario_comp;

public class ControladorUsuario {
	private Scanner s;
	private ControladorFicheros cf;
	
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
	public void CrearUsuario(Usuario_comp u) throws FileNotFoundException, IOException{
		System.out.println("Menu Creacion Usuario");
		cf.CrearUsuario_i(u);
		LogIN(u);
	}
	
	public void LogIN(Usuario_comp u) throws FileNotFoundException{
		System.out.println("Menu LogIn");
		cf.LogIN1(u);
	}
	
	
	
}
