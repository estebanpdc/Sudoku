package dominio;
import dominio.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	

	public static void main(String[] args) throws IOException {
		
		ControladorDominio cd= new ControladorDominio();	
		
	}
	
	/*private static void recorrer(Tablero t,int n) {
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
					actualizarPosiblesValorEscrito(i,j,n,valor,t);
				}
				

			}
		}*/
		
	}



	

	


<<<<<<< HEAD
	private static void actualizarPosiblesValorEscrito(int i, int j, int N, int valor, Tablero t) {
	        int caja = N * (i / N) + j / N;
	        for(int k=0;k<9; ++k) t.esborrarCandidatTauler(i, j, k);
	        for (int it = 0; it < N * N; ++it) {
	        	if (t.getValorTauler(it, j)==0) {
	                t.esborrarCandidatTauler(it, j, valor);
	        	}
	        }
	        for (int it2 = 0; it2 < N * N; ++it2) {
	        	if (t.getValorTauler(i, it2)==0) {
	                t.esborrarCandidatTauler(i, it2, valor);
	            }
	        }
	        for (int it3 = (i / N) ; it3 < N + (i / N); ++it3) {
	            for(int it4 = j / N; it4 < N + (j / N); ++it4) {
	            	if (t.getValorTauler(i, j)==0) {
		                t.esborrarCandidatTauler(i, j, valor);
		            }
	            }
	        }		
	}
	
}
=======
	

>>>>>>> origin/master
