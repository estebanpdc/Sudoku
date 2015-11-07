package clases;
public class Ranking {
	/*Creadora*/
	/*Pre: Cierto*/
	private Map<Integer,Integer> map;
	private Integer usuarios;
	public Ranking(){
		map = new Map<Integer,String>
		usuarios = 0;
		//Llamada al driver para cargar el fichero de ranking
	}
	/*Pre: Cierto*/
	/*Post: true si se ha cargado el ranking del usuario, si no existia este se crea, 
	 * false en caso de que no haya funcionado*/ 
	public boolean cargarRanking(String UserName, int time){
		boolean r = true;
		if(map.containsKey(Username)){
			time = time + map.get(UserName);
		}else usuarios++;
		map.put(UserName,time)	
	}
	//Pre: Cierto
	//Post: Devuelve el tiempo del usuario, si no existe devuelve -1
	public Integer userRanking(String UserName){
		if(map.containsKey(Username)) return map.get(UserName);
		else return -1;
	}
	
	
}
