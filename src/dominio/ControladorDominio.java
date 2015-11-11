package dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ControladorDominio {
	private Usuario_comp u;
	private Scanner s;
	
	
	ControladorDominio() throws IOException{
		inicializar();
	}
	
	private void inicializar() throws IOException {
		s= new Scanner(System.in);
		ControladorUsuario cu= new ControladorUsuario(u);
		Opciones();
	}



	private void Opciones() throws IOException {
		System.out.println("---------MENU---------");
		System.out.println("1.- Jugar partida");
		System.out.println("2.- Cargar partida");
		System.out.println("3.- Crear Sudoku");
		System.out.println("4.- Consultar Ranking");
		System.out.println("----------------------");
		switch (s.nextInt()) {
        case 1:
        		ControladorPartida cp= new ControladorPartida(u);
                 break;
        case 2:

                 break;
        case 3:  
        		 ControladorCreacionTablero ct= new ControladorCreacionTablero();
                 break;
        case 4:
        		 ControladorRanking cr= new ControladorRanking(u);
                 break;
		}
	
	}
}
