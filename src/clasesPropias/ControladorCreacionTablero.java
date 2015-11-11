package clasesPropias;

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
	
	public boolean tieneSolucion() {
		ComprobarSolucionUnica csu = new ComprobarSolucionUnica();
		return csu.tieneSolucionUnica(miTablero);
	}
}
