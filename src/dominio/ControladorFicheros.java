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
	
	public void guardarUsuario(Usuario_comp u) throws IOException {
		String ruta="/Users/estebanpdc/Desktop/usuario.txt";
		File archivo = new File(ruta);
		FileWriter fw = new FileWriter (archivo,true);
		PrintWriter pr = new PrintWriter(fw);
		pr.print(u.nombre);
		pr.print(" ");
		pr.print(u.password);
		pr.print(" ");
		pr.close();
	}
	
	public boolean usuarioExiste(String ruta , Usuario_comp u) throws FileNotFoundException {
		boolean b=false;
		File archivo= new File(ruta);
		Scanner s= new Scanner(archivo);
		String user, password;
		boolean fin=true;
		while(s.hasNext() && fin==true){
			user=s.next();
			password=s.next();
			System.out.println("entra");
			if(user.equals(u.nombre) && password.equals(u.password) ){
				System.out.println("SOn iguales");
				b=true;
				fin=false;
			}
		}
		return b;
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
