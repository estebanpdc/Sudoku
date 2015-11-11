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



	

	


	

