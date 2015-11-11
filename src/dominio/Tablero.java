package dominio;


public class Tablero extends Tablero_comp {
	
	private Integer dificultad; // 1: facil, 2: medio, 3: dificil
	
	private Integer solucion[][];
	private Record record;
	
	public Tablero (int N, int dificultad) {
		super(N);
		this.dificultad = dificultad;
		record= new Record();
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
	public  void escribir() {
		for(int i=0; i<9; ++i){
			if(i==Math.sqrt(mida) || i==Math.sqrt(mida)*2) System.out.println("------+-------+------");
			for(int j=0; j<9; ++j){
				if(j==3 || j==6) System.out.print("| ");
				System.out.print(tauler[i][j].getValor() + " ");
			}
			System.out.println(" ");
		}
	System.out.println();	
	}

	public int getNrecords(){
		return record.getNrecords();
	}
	
	public void setNrecords(int n){
		record.setnrecords(n);
	}
	public  void escribirCandidatos() {
		int n=mida;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				boolean res[] = tauler[i][j].getCandidatos();	
				System.out.print("["+i+"]["+j+"]: ");
				for(int l = 1; l < n+1; ++l) {
					if (res[l] == true) System.out.print(l);
				}
				System.out.println("");
			}
		}
		
	}
}
