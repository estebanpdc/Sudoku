package dominio;

public class Tablero extends Tablero_comp {
	
	private Integer dificultad; // 1: facil, 2: medio, 3: dificil
	
	private Integer solucion[][];
	
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
}
