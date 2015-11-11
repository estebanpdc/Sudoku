package dominio;

import java.io.FileNotFoundException;

public class Partida extends Partida_comp {

	Partida(int n, int dif,Usuario_comp u) throws FileNotFoundException{
		ControladorFicheros cf= new ControladorFicheros();
		tableroP=cf.leerTablero(n);
		usuarioP=u;
	}
	
	public void escribirTablero(){
		((Tablero) tableroP).escribir();
	}
	
	

	public void escribirRecord() {
		System.out.println("Los records del tablero son:");
		MyEntry[] m = ((Tablero) tableroP).getRecord();
		for(int i=0; i<((Tablero) tableroP).getNrecords(); ++i){
			System.out.println(i+1 + "-> " + m[i].fst() + ": " + m[i].snd() + "s" + "😂");
		}
		
	}
}
