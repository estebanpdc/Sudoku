package dominio;

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
}
