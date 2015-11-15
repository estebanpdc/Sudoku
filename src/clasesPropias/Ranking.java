package clasesPropias;

import java.util.HashMap;
/**
 * 	Contiene el ranking de los jugadores
 * 
 *	@author Grup 45 Sudoku
 *	@version 1.0
 *	@since 14-11-2015
 */
public class Ranking {
	/*Creadora*/
	/*Pre: Cierto*/
	/**
	 * 
	 */
	private HashMap<String,Integer> map;
	/**
	 * Constructora por defecto
	 */
	public Ranking(){
		map = new HashMap<String,Integer>();
		//Llamada al driver para cargar el fichero de ranking
	}
	/*Pre: Cierto*/
	/*Post: true si se ha cargado el ranking del usuario, si no existia este se crea, 
	 * false en caso de que no haya funcionado*/ 
	/**
	 * 	A&ntilde;ade al Usuario del ranking la puntuaci&oacute;n deseada.
	 * 	<p>
	 * 		Si el usuario no existe no se efectuara ningun cambio. 
	 * 	</p>
	 * 
	 * 	@param UserName		Usuario al que se le aumentara su puntuaci&oacute;n total
	 * 	@param puntuacion	Puntuaci&oacute;n obtenida en un tablero a a&ntilde;adir
	 * 	@see  java.util.HashMap
	 */
	public void actualizarRanking(String UserName, int puntuacion){
		if(map.containsKey(UserName)){
			puntuacion += map.get(UserName);
		}
		map.put(UserName,puntuacion);	
	}
	//Pre: Cierto
	//Post: Devuelve la puntuacion del usuario, si no existe devuelve -1
	/**
	 * 	Devuelve la puntuacion del usuario, si no existe devuelve -1
	 * 	<p>
	 * 		Si el usuario no existe no se efectuara ningun cambio. 
	 * 	</p>
	 * 	@return Tabla hash donde se encuentran todas las puntuaci&oacute;nes
	 */
	public HashMap<String,Integer> getPuntuacion(){
		return map;	
	}
	
}
