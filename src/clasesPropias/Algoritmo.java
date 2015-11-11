package clasesPropias;

public class Algoritmo {
	
	public Algoritmo() {}
	
	
	public static void actualizarPosiblesValorEscrito(int i, int j, int N, int valor, Tablero t) {
	       
        for (int it = 0; it < N * N; ++it)  t.esborrarCandidatTauler(i, it, valor);
        for (int it2 = 0; it2 < N * N; ++it2) t.esborrarCandidatTauler(it2, j, valor);
        for (int it3 = (i / N)*3 ; it3 < (i/N)*3+N; ++it3) {
            for(int it4 =( j / N)*3; it4 < (j/N)*3+N; ++it4) {
	                t.esborrarCandidatTauler(it3, it4, valor);
            }
        }		
	}
	
	public static void recorrer(Tablero t,int n) {
		for(int i=0; i<n*n; ++i){
			for(int j=0; j<n*n; ++j){
				boolean res[] = t.getCandidatsTauler(i, j);
				int aux=0;
				int valor=0;
				for(int l = 1; l < 10; ++l) {
					if (res[l] == true){
						++aux;
						valor=l;
					}
				}
				if(aux==1){
					t.setValorTauler(i, j, valor);
				}
				

			}
		}
	}
}
