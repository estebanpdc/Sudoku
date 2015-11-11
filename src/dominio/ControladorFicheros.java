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
	private Scanner s;
	
	
	public ControladorFicheros (){
		
	}
	
	public void guardarUsuario(Usuario_comp u) throws IOException {
		FileWriter fw = new FileWriter ("./usuario.txt",true);
		PrintWriter pr = new PrintWriter(fw);
		pr.print(u.nombre);
		pr.print(" ");
		pr.print(u.password);
		pr.print(" ");
		pr.close();
	}
	
	public void LogIN1(Usuario_comp u) throws FileNotFoundException{
		String user,password;
		s= new Scanner(System.in);
		System.out.print("Introduce tu Usuario: ");
		user = s.next();
		System.out.print("Introduce tu Password: ");
		password= s.next();
		u= new Usuario_comp(user,password);
		if(usuarioExiste(u)==false) {
			System.out.println("\n😭 login Incorrecto 😭\n");
			LogIN1(u);
		}
		else{
			System.out.println("\n😃login correcto😃 \n");
			s.close();
		}
	}
	
	public boolean usuarioExiste(Usuario_comp u) throws FileNotFoundException {
		boolean b=false;
		File archivo= new File("./usuario.txt");
		s= new Scanner(archivo);
		String user, password;
		boolean fin=true;
		while(s.hasNext() && fin==true){
			user=s.next();
			password=s.next();
			if(user.equals(u.nombre) && password.equals(u.password) ){
				b=true;
				fin=false;
			}
		}
		return b;
	}
	
	public Tablero leerTablero(int n) throws FileNotFoundException{
		Tablero t= new Tablero(n,1);
		Algoritmo a= new Algoritmo();
		String ruta = "/Users/Jesus/Desktop/sudoku.txt";
		File archivo = new File(ruta);
		Scanner s = new Scanner(archivo);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				int valor=s.nextInt();
				t.setValorTauler(i, j, valor);
				if (valor != 0) {
					t.setCandidatsTauler(i, j, new boolean[n+1]);
					a.actualizarPosiblesValorEscrito(i,j,n/3,valor,t);
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

	public void CrearUsuario_i(Usuario_comp u) throws FileNotFoundException, IOException{
	System.out.print("Introduce nuevo nombre Usuario: ");
	Scanner s= new Scanner(System.in);
	String nombre= s.next();
	if(existeNombre(nombre)){
		System.out.println("El nombre de usuario ya esta registrado");
		CrearUsuario_i(u);
	}
	else{
		System.out.print("Introduce tu nueva Password: ");
		String password= s.next();
		u= new Usuario_comp(nombre,password);
		guardarUsuario(u);
		System.out.println("Creado correctamente!\n");
	}
	
}
	
	public boolean existeNombre(String nombre) throws IOException {
		boolean b=false;
		File archivo= new File("./usuario.txt");
		Scanner s= new Scanner(archivo);
		boolean fin=true;
		String user;
		while(s.hasNext() && fin==true){
			user=s.next();
			if(s.hasNext())s.next();
			if(user.equals(nombre)){
				b=true;
				fin=false;
			}
		}
		return b;
	}
}