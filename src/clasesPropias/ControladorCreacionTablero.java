package clasesPropias;
/**
 * 	Crea un tablero, asigna un valor y ademas, comprueba si es resolubre
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since 16-11-2015
 */
public class ControladorCreacionTablero {
	/**
	 * 	El tablero con el cual comprobaremos su creaci&oacute;n es correcta
	 * 	@see Tablero
	 */
	private Tablero miTablero;
	
	
	public ControladorCreacionTablero() {}
	/**
	 * 	Constructora con parametro
	 * 	<p>
	 * 		Se le asigna un tablero por parametro
	 * 	</p>
	 * 	@param t	Tablero del cual queremos comprobar
	 */
	public ControladorCreacionTablero(Tablero t) {
		this.miTablero = t;
	}
	/**
	 * 	Se le asigna un tablero por parametro
	 * 	@param t	Tablero del cual queremos comprobar
	 */
	public void CargarTablero(Tablero t) {
		this.miTablero = t;
	}
	/**
	 * 	A&ntilde;ade un valor en la casilla que definamos segun su posici&oacute;n en el tablero
	 * 	@param	x	Posici&oacute;n fila
	 * 	@param	y	Posici&oacute;n columna
	 * 	@param	valor	Valor a poner en una casilla del tablero
	 */
	public void setNum(int x, int y, int valor) {
		miTablero.setValorTauler(x, y, valor);
	}
	/**
	 * 	Comprobamos que el tablero asignado a esta clase tenga una soluci&oacute;n unica
	 * 	<p>
	 * 		Consideramos un sudoku resoluble aquel que su soluci&oacute;n sea posible y unica.
	 * 	</p>
	 * 	@return true en caso de tenga soluci&oacute;n, falso en caso contrario.
	 * 	@throws Exception Error relacionado con el acceso a los ficheros
	 */
	public boolean tieneSolucion() throws Exception {
		ComprobarSolucionUnica csu = new ComprobarSolucionUnica();
		ControladorFicheros cf = new ControladorFicheros();
		miTablero= cf.leerTablero(9);
		return csu.tieneSolucionUnica(miTablero);
	}
}
