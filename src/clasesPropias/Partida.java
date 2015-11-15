0package clasesPropias;

import java.io.FileNotFoundException;
import java.io.IOException;

import clasesComunes.Partida_comp;
import clasesComunes.Usuario_comp;
/**
 * 	Extension de Partida_comp para agregar funcionalidades para el sudoku.
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since 13-11-2015
 * 	@see Partida
 *
 */
public class Partida extends Partida_comp {
	/**
	 * 	Constructora de la clase Partida
	 * 	<p>
	 * 	Las dificultades que la partida puede tener son los siguientes:<br/> 1: Facil, 2: Medio, 3: Dificil
	 * 	</p>
	 * 	@param n 	El tama&ntilde;o de las filas/columnas del sudoku
	 * 	@param dif 	La dificultad asignada a la partida.
	 * 	@param u	El usuario asignado a este fichero
	 * 	@see Usuario_comp
	 * 	@throws java.io.IOException Al haber un problema con el archivo que contiene los usuarios no pueda abrirlo 
	 * 	(sea por priviegios o por que este no exista)
	 */
	Partida(int n, int dif,Usuario_comp u) throws IOException{
		ControladorFicheros cf= new ControladorFicheros();
		tableroP=cf.leerTablero(n);
		usuarioP=u;
	}
	/**
	 * Escribe por pantalla el tablero asignado a la partida
	 * @see Tablero
	 */
	public void escribirTablero(){
		((Tablero) tableroP).escribir();
		//((Tablero) tableroP).escribirCandidatos();
	}
	
	
	/**
	 * Muestra por consola los records asignados al tablero asignado a la partida
	 * @see Record
	 */
	public void escribirRecord() {
		System.out.println("Los records del tablero son:");
		MyEntry[] m = ((Tablero) tableroP).getRecord();
		for(int i=0; i<((Tablero) tableroP).getNrecords(); ++i){
			System.out.println(i+1 + "-> " + m[i].fst() + ": " + m[i].snd() + "s" + "😂");
		}
		
	}
}
