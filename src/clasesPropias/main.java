package clasesPropias;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	

	public static void main(String[] args) throws Exception {
		Scanner s;
		prueba();
		s=new Scanner(System.in);
		System.out.println("1.- Modo programa");
		System.out.println("2.- Modo Drivers");
		switch(s.nextInt()){
			case 1:
					ControladorDominio cd= new ControladorDominio();
					break;
			case 2: Master_Driver md= new Master_Driver();
					break;
			
		};
		s.close();		
		
	}

	private static void prueba() throws Exception {
		NakedPairs np= new NakedPairs();
		ControladorFicheros cf= new ControladorFicheros();
		Algoritmo a= new Algoritmo();
		Tablero t= cf.leerTablero(9);
		t.escribir();
		//t.escribirCandidatos();
		np.nakedPairs(t);
		t.escribirCandidatos();
		a.recorrer(t, 3);
	//	a.recorrer(t, 3);
	//	a.recorrer(t, 3);
		//t.escribir();
		
	}
	
		
	}



	

	


	

