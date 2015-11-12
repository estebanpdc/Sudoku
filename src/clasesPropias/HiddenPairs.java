package clasesPropias;

public class HiddenPairs {
	public void hiddenPairs(Tablero t) {
		boolean res[];
		int n = t.getMida();
		for(int i=0; i<n*n; ++i){
			for(int j=0; j<n*n; ++j){
				res = t.getCandidatsTauler(i, j);
				comprobarFila(t,i,j,res);
				comprobarColumna(t,i,j,res);
				comprobarRegion(t,i,j,res);
			}
		}
	}

	private static void comprobarFila(Tablero t, int i, int j, boolean[] res) {
		int n = t.getMida();
		boolean aux[];
		boolean aux2[];
		int cont = 0;
		for(int k = 0; k < n*n; ++k) {
			if (k != i) {	
				cont = 0;
				aux = t.getCandidatsTauler(i, k);
				for(int it = 0; it < n*n; ++it) {
					if (res[it] != aux[it]) res[it] = false;
				}
				for(int it2 = 0; it2 < n*n; ++it2) {
					if(it2 != i && it2 != k) {
						for(int it3 = 0; it3 < n*n; ++it3) {
							if(res[it3] == aux[it3]) res[it3] = false;
						}
					}
				}
				for(int last = 0; last < n*n; ++last) {
					if(res[last]) ++cont;
				}
				if(cont == 2) {
					t.setCandidatsTauler(i, j, res);
					t.setCandidatsTauler(i, k, res);
				}
			}

		}
	}

	private static void comprobarColumna(Tablero t, int i, int j, boolean[] res) {
		int n = t.getMida();
		boolean aux[];
		boolean aux2[];
		int cont = 0;
		for(int k = 0; k < n*n; ++k) {
			if (k != j) {	
				cont = 0;
				aux = t.getCandidatsTauler(k, j);
				for(int it = 0; it < n*n; ++it) {
					if (res[it] != aux[it]) res[it] = false;
				}
				for(int it2 = 0; it2 < n*n; ++it2) {
					if(it2 != i && it2 != k) {
						for(int it3 = 0; it3 < n*n; ++it3) {
							if(res[it3] == aux[it3]) res[it3] = false;
						}
					}
				}
				for(int last = 0; last < n*n; ++last) {
					if(res[last]) ++cont;
				}
				if(cont == 2) {
					t.setCandidatsTauler(i, j, res);
					t.setCandidatsTauler(k, j, res);
				}
			}

		}
	}

	private static void comprobarRegion(Tablero t, int i, int j, boolean[] res) {
		int n = t.getMida();
		int box_size = (int) Math.sqrt(n);
		boolean aux[];
		boolean aux2[];
		int cont = 0;
		for(int k=i/box_size*box_size; k<i/box_size*box_size+box_size; ++k){
			for (int l=j/box_size*box_size; l < j/box_size*box_size+box_size; ++l){
				if (k != i || l != j) {	
					cont = 0;
					aux = t.getCandidatsTauler(k, l);
					for(int it = 0; it < n*n; ++it) {
						if (res[it] != aux[it]) res[it] = false;
					}
					for(int it2 = 0; it2 < n*n; ++it2) {
						if(it2 != i && it2 != k) {
							for(int it3 = 0; it3 < n*n; ++it3) {
								if(res[it3] == aux[it3]) res[it3] = false;
							}
						}
					}
					for(int last = 0; last < n*n; ++last) {
						if(res[last]) ++cont;
					}
					if(cont == 2) {
						t.setCandidatsTauler(i, j, res);
						t.setCandidatsTauler(k, l, res);
					}
				}

			}
		}
	}
}
