package dominio;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map.Entry;

public class Tablero extends Tablero_comp {
	
	private Integer dificultad; // 1: facil, 2: medio, 3: dificil
	
	private Integer solucion[][];
	private Record record;
	
	public Tablero (int N, int dificultad) {
		super(N);
		this.dificultad = dificultad;
	}
	
	public void setMatrizSolucion(Integer[][] matriz) {
		this.solucion = matriz;
	}
	
	public Integer getPosicionMatrizSolucion(int x, int y) {
		return solucion[x][y];
	}
	
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public Integer getDificultad() {
		return dificultad;
	}
	
	public Entry<String,Integer>[] getRecord() {
		return record.getClasificacion();
	}
	
	public void setTiempoRecord(String usuario, Integer tiempo) {
		MyEntry<String, Integer> res = new MyEntry<String,Integer>(usuario,tiempo);
		record.setClasificacion(res);
	}
}
