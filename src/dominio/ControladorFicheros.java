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
}
