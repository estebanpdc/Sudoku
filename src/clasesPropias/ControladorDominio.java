package clasesPropias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import clasesComunes.Usuario_comp;
/**
 * 	Crea un tablero, asigna un valor y ademas, comprueba si es resolubre
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since 16-11-2015
 */
public class ControladorDominio {
	/**
	 * 	Usuario que contendra el dominio
	 */
	private Usuario_comp u;
	/**
	 * 	Herramienta escaner que permite leer secuentas de cadenas, enteros, etc. 
	 * 	que nos resultara util para saber las elecci&oacute;nes del usuarios
	 */
	private Scanner s;
	
	/**
	 *	Constructora por defecto
	 *	@throws IOException
	 */
	ControladorDominio() throws IOException{
		inicializar();
	}
	/**
	 * 	Inicializa la clase, cargando el usuario	
	 * 
	 *	@throws IOException
	 */
	private void inicializar() throws IOException {
		s= new Scanner(System.in);
		ControladorUsuario cu= new ControladorUsuario(u);
		Opciones();
	}


	/**
	 * 	Opciones que puede usar el usuario
	 * 
	 * 	@param IOException Problema ocasionado intentar leer el siguiente valor integer
	 */
	private void Opciones() throws IOException {
		System.out.println("---------MENU---------");
		System.out.println("1.- Jugar partida");
		System.out.println("2.- Cargar partida");
		System.out.println("3.- Crear Sudoku");
		System.out.println("4.- Consultar Ranking");
		System.out.println("----------------------");
		switch (s.nextInt()) {
        case 1:
        		ControladorPartida cp= new ControladorPartida(u);
                 break;
        case 2:

                 break;
        case 3:  
        		 ControladorCreacionTablero ct= new ControladorCreacionTablero();
                 break;
        case 4:
        		 ControladorRanking cr= new ControladorRanking(u);
                 break;
		}
	
	}
}
