package dominio;


import java.io.IOException;
import java.util.Scanner;

public class ControladorPartida {
	private Partida p;
	private Scanner br;
	
	ControladorPartida(Usuario_comp u) throws IOException{
		br = new Scanner(System.in);
		inicializarPartida(u);
		jugar();
		p.escribirRecord();
	}


	private void jugar() throws IOException {
		int valor=0;
		int i=0;
		int j=0;
		System.out.println("Esctibe -1 -1 -1 para acabar");
		i= br.nextInt();
		j=br.nextInt();
		valor=br.nextInt();
		while(valor!=-1){
			p.modificarValorCasilla(i, j, valor);
			p.escribirTablero();
			i= br.nextInt();
			j=br.nextInt();
			valor=br.nextInt();
		}
		
	}


	private void inicializarPartida(Usuario_comp u) throws IOException {
		ControladorFicheros cf= new ControladorFicheros();
		System.out.println("De que tamaño quieres el tablero?");
		int tamaño = br.nextInt();
		System.out.println("y de que dificultad?");
		int dificultad = br.nextInt();
		System.out.println("\n");
		p= new Partida(tamaño,dificultad,u);
		p.escribirTablero();
		
	}
}
