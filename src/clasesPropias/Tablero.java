package clasesPropias;

import clasesComunes.Tablero_comp;

/**
 * 	Clase extendida del tablero_comp para implementarla en un sudoku
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since	13-11-2015 
 *	@see 	Tablero_comp
 */
public class Tablero extends Tablero_comp {
	/**
	 * Define el nivel de dificultad
	 * <p>
	 * 1: Facil
	 * 2: Normal
	 * 3: Dificil
	 * </p>
	 */
	private Integer dificultad; // 1: facil, 2: medio, 3: dificil
	/**
	 * Contiene el tablero solucionado
	 */
	private Integer solucion[][];
	/**
	 * Contiene el record asociado al tablero
	 * @see Record
	 */
	private Record record;
	/**
	 * 	Constructora de la clase
	 *	
	 *	@param N El tama&ntilde;o del tablero que tendra el tablero.
	 *	@param dificultad Define el nivel de dificultad del tablero.
	 */
	public Tablero (int N, int dificultad) {
		super(N);
		this.dificultad = dificultad;
		record= new Record();
	}
	/**
	 * 	A&ntilde;ade una matriz de la cual esta contendra la soluci&oacute; del sudoku.
	 * 	@param matriz Matriz entera bidimensional que contiene la soluci&oacute;n del sudoku
	 */
	public void setMatrizSolucion(Integer[][] matriz) {
		this.solucion = matriz;
	}
	/**
	 * 	Sobreescribe los conjuntos de booleanos de una casilla por otros conjuntos de booleanos
	 * 	@param x	define la fila en que se posiciona la casilla
	 * 	@param y	define la columna en que se posiciona la casilla
	 * 	@param b	booleanos que identifican los valores
	 */
	public void setCandidatsTauler(int x, int y, boolean[] b) {
		tauler[x][y].setCandidatos(b);
	}
	/**
	 * 	Devuelve de la casilla definida, el valor de la soluci&oacute;n. 
	 * 	@param x	define la fila en que se posiciona la casilla
	 * 	@param y	define la columna en que se posiciona la casilla
	 * 	@return		el valor de la casilla solucionada
	 */
	public Integer getPosicionMatrizSolucion(int x, int y) {
		return solucion[x][y];
	}
	/**
	 * 	Define la dificultad
	 * 	@param dificultad	El nivel de dificultad
	 */
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}	
	/**
	 * 	Devuelve la dificultad
	 * 	@return Nivel de dificultad
	 */
	public Integer getDificultad() {
		return dificultad;
	}
	/**
	 * 	Devuelve en un vector el record del sistema
	 * 	@return Devuelve un vector que contiene los mejores 5 tiempos.
	 * 	@see Record
	 */
	public MyEntry[] getRecord() {
		return record.getClasificacion();
	}
	/**
	 * 	Define una entrada de record y la aplica en la clasificaci&oacute;n de record
	 * 
	 * 	@param usuario 	El usuario que ha realizado el tiempo
	 * 	@param tiempo	El tiempo que ha tardado
	 * 	@see MyEntry
	 * 	@see Record
	 */
	public void setTiempoRecord(String usuario, Integer tiempo) {
		MyEntry res = new MyEntry(usuario,tiempo);
		record.setClasificacion(res);
	}	
	/**
	 * 	Escribe por el canal de salida estandar de java un tablero de sudokus
	 */
	public void escribir() {
		for(int i=0; i<9; ++i){
			if(i==Math.sqrt(mida) || i==Math.sqrt(mida)*2) System.out.println("------+-------+------");
			for(int j=0; j<9; ++j){
				if(j==3 || j==6) System.out.print("| ");
				System.out.print(tauler[i][j].getValor() + " ");
			}
			System.out.println(" ");
		}
	System.out.println();	
	}

	/**
	 * 	Devuelve la cantidad de records que posee el tablero
	 * 	@return las entradas totales de records que tiene el tablero
	 * 	@see Record
	 */
	public int getNrecords(){
		return record.getNrecords();
	}
	/** 
	 * 	Define el numero de records que puede tener el tablero
	 * 
	 * 	@param n El numero de records que tiene el tablero
	 *	@see Record
	 */
	public void setNrecords(int n){
		record.setnrecords(n);
	}
	/**
	 * 	Escribe todos los candidatos que hay en cada casilla por el canal de salida estandar
	 */
	public  void escribirCandidatos() {
		int n=mida;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				boolean res[] = tauler[i][j].getCandidatos();	
				System.out.print("["+i+"]["+j+"]: ");
				for(int l = 1; l < n+1; ++l) {
					if (res[l] == true) System.out.print(l);
				}
				System.out.println("");
			}
		}
		
	}
}
