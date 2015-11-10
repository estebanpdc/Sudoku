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

	

	public static void main(String[] args) throws FileNotFoundException {
		int n=3;
		Tablero t;
		t= new Tablero(n*n,0);
		String ruta = "/Users/estebanpdc/Desktop/prueba.txt";
		File archivo = new File(ruta);
		Scanner s = new Scanner(archivo);
		initCandidatos(t);
		for(int i=0; i<n*n; ++i){
			for(int j=0; j<n*n; ++j){
				int valor=s.nextInt();
				t.setValorTauler(i, j, valor);
				if (valor != 0) {
					actualizarPosiblesValorEscrito(i,j,n,valor,t);
				}
			}
		}
		//escribir(t);
		escribirCandidatos(t);
		s.close();
		
		
	}
	
	private static void escribir(Tablero t) {
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				System.out.println(t.getValorTauler(i, j));
			}
		}
		
	}

	private static void initCandidatos(Tablero t) {
		boolean[] b;
		b= new boolean[10];
		for (int k = 0; k < 10; ++k) {
			b[k] = true;
		}
		int n=t.getMida();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				t.setCandidatsTauler(i, j, b);
			}
		}
		
	}

	private static void escribirCandidatos(Tablero t) {
		boolean[] b;
		b= new boolean[10];
		int n=t.getMida();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				boolean res[] = t.getCandidatsTauler(i, j);	
				for(int l = 1; l < 10; ++l) {
					if (res[l] = true) System.out.print(l);
				}
				System.out.println("");
			}
		}
		
	}

	private static void actualizarPosiblesValorEscrito(int i, int j, int N, int valor, Tablero t) {
	        int caja = N * (i / N) + j / N;
	        for(int k=0;k<9; ++k) t.esborrarCandidatTauler(i, j, k);
	        for (int it = 0; it < N * N; ++it) {
	          //  if (t.getValorTauler(it, j)==0) {
	                t.esborrarCandidatTauler(it, j, valor);
	           // }
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
