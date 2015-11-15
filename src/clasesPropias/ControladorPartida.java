package clasesPropias;


import java.io.IOException;
import java.util.Scanner;

import clasesComunes.Usuario_comp;
/**
 * 	La partida se crea y el usuario va resolviendo un sudoku asociado a la partida
 * 
 *	@author Grup 45 Sudoku
 *	@version 1.0
 *	@since 14-11-2015
 *
 */
public class ControladorPartida {
	/**
	 * Partida asociada a esta clase	
	 */
	private Partida p;
	/**
	 * 	Escaner utilizado para la lectura de ficheros y entradas de pantalla
	 */
	private Scanner br;
	/**
	 * 	Fichero del cual contiene los datos de una partida asignada 
	 */
	private ControladorFicheros cf;
	
	/**
	 * 	Constructora por defecto. 
	 * 	<p>
	 * 		Carga los controladores por defecto
	 * 	</p>
	 * 
	 * 	@param	u	Usuario que se cargara
	 * 	@param	cargar	Partida nueva (true) o recuperar una guardada
	 * 	@throws	IOException	Problema al no poder leer una entrada pasada por teclado	
	 */
	ControladorPartida(Usuario_comp u, boolean cargar) throws IOException{
		br = new Scanner(System.in);
		cf = new ControladorFicheros();
		if(cargar) {
			p = cf.cargarPartida(u);
		}
		else inicializarPartida(u);
		jugar();
		p.escribirRecord();
	}

	/**
	 * 	Se le pide al usuario que modifique las casillas
	 * 
	 * 	@throws	IOException	Problema al no poder leer una entrada pasada por teclado	
	 */
	private void jugar() throws IOException {
		ControladorFicheros cf = new ControladorFicheros();
		int valor=0;
		int i=0;
		int j=0;
		System.out.println("<<Escribe -1 -1 -1 para  salir, -2 -2 -2 para guardar el estado de la partida y salir, -3 -3 -3 para obtener ayuda y -4 -4 -4 para comprobar si está solucionado>>");
		p.escribirTablero();
		System.out.println("Modificar casilla: i j valor:");
		i= br.nextInt();
		j=br.nextInt();
		valor=br.nextInt();
		boolean fin = false;
		long def = 0;
		long startTime = System.nanoTime();
		while(!fin){
			if(valor <=p.getTablero().getMida() && valor > 0 ) {
				if(p.getPorDefecto(i, j)) System.out.println("Casilla por defecto");
				else if (p.check(valor,i,j,p.getTablero().getMida())) System.out.println("Valor no valido para esa posicion");
				else {
					p.modificarValorCasilla(i, j, valor);
					p.escribirTablero();
				}
				System.out.println("Modificar casilla: i j valor:");
				i= br.nextInt();
				j=br.nextInt();
				valor=br.nextInt();
			}
			else if (valor == -1 || valor == -2 || valor == -3 || valor == -4) fin = false;
			else System.out.println("Valor no valido");
		}
		long stopTime = System.nanoTime();
		def += stopTime - startTime;
		if (valor == -1) {
			p.escribirRecord();
			fin = true;
		}
		else if (valor == -2) {
			p.setTiempo(p.getTiempo()+def);
			cf.guardarPartida(p);
			System.out.println("Partida guardada");
			fin = true;
		}
		else if (valor == -3) {
			if(solucionCorrecta()) {
				p.getTablero().ayuda();
				p.escribirTablero();
				System.out.println("Modificar casilla: i j valor:");
			}
			else System.out.println("Los numeros colocados no son correctos");
			System.out.println("Modificar casilla: i j valor:");
			i= br.nextInt();
			j=br.nextInt();
			valor=br.nextInt();
			
		}
		else if (valor == -4) {
			if(solucionCorrecta()) {
				System.out.println("Sudoku correcto. Tu tiempo es "+(def / 1000 + p.getTiempo()) +" segundos");
				((Tablero) p.getTablero()).setTiempoRecord(p.getUsuario().consultar_nombre(), (int) ((def / 1000) + p.getTiempo()));
				p.escribirRecord();
				fin = true;
			}
			else {
				System.out.println("Solucion Incorrecta");
				System.out.println("Modificar casilla: i j valor:");
				i= br.nextInt();
				j=br.nextInt();
				valor=br.nextInt();
			}
		}
	}

	/**
	 * 	Inicia la creaci&oacute;n de una partida, definiendo las caracterisiticas del tablero con el que deseamos jugar
	 * 	@param	u	Usuario que se le asignara la partida
	 * 	@throws	IOException	Problema al no poder leer una entrada pasada por teclado	
	 */
	private void inicializarPartida(Usuario_comp u) throws IOException {
		ControladorFicheros cf= new ControladorFicheros();
		System.out.println("De que tamaño quieres el tablero?");
		int tamano = br.nextInt();
		System.out.println("y de que dificultad?");
		int dificultad = br.nextInt();
		System.out.println("\n");
		p= new Partida(tamano,dificultad,u,0);
		p.escribirTablero();

	}
	/**
	 * 	Compara el tablero solucionado con el usuario o para un usuario 
	 * 	@return	True si la soluci&oacute;n es la correcta, false en caso contrario
	 */
	private boolean solucionCorrecta() {
		boolean b = true;
		for (int i = 0; i < p.getTablero().getMida() && b; ++i) {
			for(int j = 0; j < p.getTablero().getMida() && b; ++j) {
				if (p.getTablero().getValorTauler(i, j) != ((Tablero) p.getTablero()).getPosicionMatrizSolucion(i, j))  b = false;
			}
		}
		return b;
	}
}
