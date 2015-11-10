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
		for(int i=0; i<n*n; ++i){
			for(int j=0; j<n*n; ++j){
				int valor=s.nextInt();
				t.setValorTauler(i, j, valor);
				if (valor != 0) {
					t.setCandidatsTauler(i, j, new boolean[n*n+1]);
					actualizarPosiblesValorEscrito(i,j,n,valor,t);
				}
			}
		}
		recorrer(t,n);
		escribir(t);
		escribirCandidatos(t);
		s.close();
		
		
	}
	
	private static void recorrer(Tablero t,int n) {
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
		}
		
	}

	private static void escribir(Tablero t) {
		for(int i=0; i<9; ++i){
			if(i==3 || i==6) System.out.println("---------------------");
			for(int j=0; j<9; ++j){
				if(j==3 || j==6) System.out.print("| ");
				System.out.print(t.getValorTauler(i, j)+ " ");
			}
			System.out.println(" ");
		}
		
	}

	

	private static void escribirCandidatos(Tablero t) {
		boolean[] b;
		b= new boolean[10];
		int n=t.getMida();
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				boolean res[] = t.getCandidatsTauler(i, j);	
				System.out.print("["+i+"]["+j+"]: ");
				for(int l = 1; l < 10; ++l) {
					if (res[l] == true) System.out.print(l);
				}
				System.out.println("");
			}
		}
		
	}

	private static void actualizarPosiblesValorEscrito(int i, int j, int N, int valor, Tablero t) {
	        int caja = N * (i / N) + j / N;
	        for (int it = 0; it < N * N; ++it)  t.esborrarCandidatTauler(i, it, valor);
	        for (int it2 = 0; it2 < N * N; ++it2) t.esborrarCandidatTauler(it2, j, valor);
	        for (int it3 = (i / N)*3 ; it3 < (i/N)*3+N; ++it3) {
	            for(int it4 =( j / N)*3; it4 < (j/N)*3+N; ++it4) {
		                t.esborrarCandidatTauler(it3, it4, valor);
	            }
	        }		
	}
	
}
