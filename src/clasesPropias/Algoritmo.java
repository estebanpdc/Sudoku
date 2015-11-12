package clasesPropias;

public class Algoritmo {
	
	public Algoritmo() {}
	
	
	public static void actualizarPosiblesValorEscrito(int i, int j, int valor, Tablero t) {
	     int box_size= (int) Math.sqrt(t.getMida());
        for (int it = 0; it < t.getMida(); ++it)  t.esborrarCandidatTauler(i, it, valor);
        for (int it2 = 0; it2 < t.getMida(); ++it2) t.esborrarCandidatTauler(it2, j, valor);
        for (int it3 = (i / box_size)*box_size ; it3 < (i/box_size)*3+box_size; ++it3) {
            for(int it4 =( j / box_size)*3; it4 < (j/box_size)*box_size+box_size; ++it4) {
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
				for(int l = 1; l < t.getMida(); ++l) {
					if (res[l] == true){
						++aux;
						valor=l;
					}
				}
				if(aux==1){
					t.setValorTauler(i, j, valor);
					actualizarPosiblesValorEscrito(i, j, valor, t);
				}
				

			}
		}
	}
}
