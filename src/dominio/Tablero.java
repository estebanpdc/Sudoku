package dominio;

public class Tablero extends Tablero_comp {
	private Integer solucion[][];
	private Integer dificultad; // 1: facil, 2: medio, 3: dificil
	
	public Tablero() {
		
	}
	

	
	public void setMatrizSolucion(Integer[][] matriz) {
		this.solucion = matriz;
	}
	
	public Integer[][] getMatrizSolucion() {
		return solucion;
	}
	
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	public Integer getDificultad() {
		return dificultad;
	}
}
