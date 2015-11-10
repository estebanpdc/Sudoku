package dominio;

public class CrearTablero {
	public CrearTablero() {
		
	}
	
	public Tablero generarTablero(int dificultad, int n) {
		Tablero t = new Tablero(dificultad, n);
		return t;
	}
}
