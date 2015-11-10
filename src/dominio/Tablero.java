package dominio;


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
	
	public void setCandidatsTauler(int x, int y, boolean[] b) {
		tauler[x][y].setCandidatos(b);
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
	
	public MyEntry[] getRecord() {
		return record.getClasificacion();
	}
	
	public void setTiempoRecord(String usuario, Integer tiempo) {
		MyEntry res = new MyEntry(usuario,tiempo);
		record.setClasificacion(res);
	}
}
