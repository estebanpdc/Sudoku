package dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControladorDominio {
	private BufferedReader br;
	private Usuario_comp u;
	
	
	ControladorDominio() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		inicializar();
	}
	
	private void inicializar() throws IOException {
		pedirLogin();
		//escribirOpciones();
	}

	private void pedirLogin() throws IOException {
		ControladorFicheros cf= new ControladorFicheros();
		String user,password;
		System.out.print("Introduce tu Usuario: ");
		user=br.readLine();
		System.out.print("Introduce tu Password: ");
		password=br.readLine();
		u= new Usuario_comp(user,password);
		if(cf.usuarioExiste("/Users/estebanpdc/Desktop/usuario.txt", u)) System.out.print("Login correcto ");
		System.out.println();
		
	}

	private void escribirOpciones() throws IOException {
		String opcion;
		System.out.println("---------MENU---------");
		System.out.println("1.- Jugar partida");
		System.out.println("2.- Cargar partida");
		System.out.println("3.- Crear Sudoku");
		System.out.println("4.- Consultar Ranking");
		System.out.println("----------------------");
		opcion= br.readLine();
		switch (opcion) {
        case "1":
        		ControladorPartida cp= new ControladorPartida(u);
                 break;
        case "2":

                 break;
        case "3":  
        		 ControladorCreacionTablero ct= new ControladorCreacionTablero();
                 break;
        case "4":
        		 ControladorRanking cr= new ControladorRanking(u);
                 break;
		}
	
	}
}
