package dominio;

public class ControladorCreacionTablero {
	private Tablero miTablero;
	
	
	public ControladorCreacionTablero() {}
	
	public ControladorCreacionTablero(Tablero t) {
		this.miTablero = t;
	}
	
	public void CargarTablero(Tablero t) {
		this.miTablero = t;
	}
	
	public void setNum(int x, int y, int valor) {
		miTablero.setValorTauler(x, y, valor);
	}
	
	public boolean tieneSolucion() throws Exception {
		ComprobarSolucionUnica csu = new ComprobarSolucionUnica();
		return csu.tieneSolucionUnica(miTablero);
	}
	
	public Integer nivelDificultad() {
		ComprobarDificultad cd = new ComprobarDificultad();
		return cd.dificultad();
	}
	
	public Tablero crearSudoku(int dificultad, int n) {
		CrearTablero ct = new CrearTablero();
		return ct.generarTablero(dificultad, n);
	}
	
}
