package clasesPropias;

public class HiddenPairs {
	public void hiddenPairs(Tablero t) {
			int n = t.getMida();
			for(int i=0; i<n*n; ++i){
				for(int j=0; j<n*n; ++j){
					boolean res[] = t.getCandidatsTauler(i, j);
					res = comprobarFila(t,i,j,res);
				}
			}
	}
	
	private static boolean[] comprobarFila(Tablero t, int i, int j, boolean[] res) {
		int n = t.getMida();
		boolean aux[];
		boolean aux2[];
		for(int k = 0; k < n*n; ++k) {
			if (k != i) {			
				aux = t.getCandidatsTauler(i, k);
				for(int it = 0; it < n*n; ++it) {
					if (res[it] != aux[it]) res[it] = false;
				}
				for(int it2 = 0; it2 < n*n; ++it2) {
					if(it2 != i && it2 != k) {
						
					}
				}
			}
		}
		return res;
	}
}
