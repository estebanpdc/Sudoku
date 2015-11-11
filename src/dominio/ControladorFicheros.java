package dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControladorFicheros {
	
	public ControladorFicheros (){
		
	}
	
	public void guardarUsuario(String nombrefichero, String usuario, String password) throws IOException {
		File archivo = new File(nombrefichero);
		FileWriter fw = new FileWriter (archivo);
		PrintWriter pr = new PrintWriter(fw);
		pr.println(usuario);
		pr.println(password);
		pr.close();
	}
	
	public Tablero leerTablero(int n) throws FileNotFoundException{
		Tablero t= new Tablero(n,1);
		Algoritmo a= new Algoritmo();
		String ruta = "/Users/estebanpdc/Desktop/prueba.txt";
		File archivo = new File(ruta);
		Scanner s = new Scanner(archivo);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				int valor=s.nextInt();
				t.setValorTauler(i, j, valor);
				if (valor != 0) {
					t.setCandidatsTauler(i, j, new boolean[n+1]);
					//a.actualizarPosiblesValorEscrito(i,j,n/3,valor,t);
				}
			}
		}
		//t.setNrecords(s.nextInt());
		int aux=s.nextInt();
		for(int k=0; k<aux; ++k){
			String user=s.next();
			int puntuacion= s.nextInt();
			t.setTiempoRecord(user,puntuacion);
		}
		s.close();
		return t;
	}
}
