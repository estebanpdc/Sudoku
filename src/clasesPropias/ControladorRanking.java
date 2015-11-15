package clasesPropias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import clasesComunes.Usuario_comp;
/**
 * 
 *	@author Grup 45 Sudoku
 *	@version 1.0
 *	@since 15-11-2015
 */
public class ControladorRanking {
	/**
	 * 	Ranking Usuario
	 */
	private Ranking r;
	private ControladorFicheros cf;
	/**
	 * Constructora por defecto
	 */
	ControladorRanking() throws IOException{
		cf = new ControladorFicheros();
		r = cf.leerRanking();
		r.escribirRanking();
		System.out.println("");
		System.out.println("Pulse una tecla para salir");
		Scanner s= new Scanner(System.in);
		s.nextInt();
		s.close();		
	}
	
	
}
