package clasesPropias;

import java.util.HashMap;
public class Ranking {
	/*Creadora*/
	/*Pre: Cierto*/
	private HashMap<String,Integer> map;
	public Ranking(){
		map = new HashMap<String,Integer>();
		//Llamada al driver para cargar el fichero de ranking
	}
	/*Pre: Cierto*/
	/*Post: true si se ha cargado el ranking del usuario, si no existia este se crea, 
	 * false en caso de que no haya funcionado*/ 
	public void actualizarRanking(String UserName, int puntuacion){
		if(map.containsKey(UserName)){
			puntuacion += map.get(UserName);
		}
		map.put(UserName,puntuacion);	
	}
	//Pre: Cierto
	//Post: Devuelve la puntuacion del usuario, si no existe devuelve -1
	public HashMap<String,Integer> getPuntuacion(){
		return map;	
	}
	
}
