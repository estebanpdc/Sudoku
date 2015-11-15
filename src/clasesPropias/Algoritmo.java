package clasesPropias;
/**
 * 	Clase que define algoritmos sencillos para solventar un sudoku
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since 13-11-2015
 *
 */
public class Algoritmo {
	/**
	 * Constructora por defecto
	 */
	public Algoritmo() {}
	

	/**
	 * 	Actualiza los posibles candidatos con las 
	 * 	coordenadas de la casilla definida con un valor determinado
	 * 
	 *  <p>
	 *  	Elimina los candidatos que se encuentren en la casilla posici&oacute;n
	 *  </p>
	 * 
	 *	@param 	i		posici&oacute;n fila
	 * 	@param 	j		posici&oacute;n columna
	 * 	@param 	valor	Valor candidato a eliminar
	 * 	@param 	t		Tablero a modificar
	 * 	@see 	Tablero
	 */
	public static void actualizarPosiblesValorEscrito(int i, int j, int valor, Tablero t) {
	     int box_size= (int) Math.sqrt(t.getMida());
        for (int it = 0; it < t.getMida(); ++it)  t.esborrarCandidatTauler(i, it, valor);
        for (int it2 = 0; it2 < t.getMida(); ++it2) t.esborrarCandidatTauler(it2, j, valor);
        for (int it3 = (i / box_size)*box_size ; it3 < (i/box_size)*3+box_size; ++it3) {
            for(int it4 =( j / box_size)*3; it4 < (j/box_size)*box_size+box_size; ++it4) {
	                t.esborrarCandidatTauler(it3, it4, valor);
            }
        }		
	}
	/**
	 * 	Aplicamos la t&eacute;cnica de busqueda hiddenPairs para encontrar candidatos 
	 * 	a descartar
	 * 
	 * 	@param 	t	Tablero en el cual trabajamos
	 * 	@param	n	Tablero n^2 x n^2 en el cual trabajaremos (EJ: n = 3 = 9x9)
	 * 	@see 	Tablero 
	 */
	public static void hiddenSingles(Tablero t,int n) {
		for(int i=0; i<n*n; ++i){
			for(int j=0; j<n*n; ++j){
				boolean res[] = t.getCandidatsTauler(i, j);
				int aux=0;
				int valor=0;
				for(int l = 1; l < t.getMida(); ++l) {
					if (res[l] == true){
						++aux;
						valor=l;
					}
				}
				if(aux==1){
					t.setValorTauler(i, j, valor);
					actualizarPosiblesValorEscrito(i, j, valor, t);
				}
				
			}
		}
	}
}
