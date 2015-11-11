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
	

	public static void main(String[] args) throws IOException {
		Scanner s;
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
	
		
	}



	

	


	

