package clasesPropias;

import clasesComunes.Usuario_comp;
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

import clasesComunes.Usuario_comp;

/**
 * 	Clase relacionada con la creac&oacute;n de ficheros para almacenar los datos de una sesion para su posterior uso	
 * 
 *	@author Grup 45 Sudoku
 *	@version 1.0
 *	@since 14-11-2015
 *
 */
public class ControladorFicheros {
	/**
	 * 	Escaner utilizado para la lectura de ficheros y entradas de pantalla
	 */
	private Scanner s;
	/**
	 * 	Ruta del fichero de Usuarios
	 */
	private String dataUsers;
	/**
	 * 	Ruta del fichero de tableros
	 */
	private String dataTableros;
	/**
	 * 	Ruta del fichero de ranking
	 */
	private String dataRanking;
	/**
	 * 	Constructora por defecto
	 */
	public ControladorFicheros (){
		dataUsers = "./data/usuarios.txt";
		dataTableros= "./data/tableros.txt";
		dataRanking= "./data/ranking.txt";
	}

	/**
	 * 	Almacena el nuevo usuario definido como un nuevo usuario en el fichero
	 * 
	 * 	@param	u	 			se almacenara en el fichero de usaurios
	 * 	@throws	IOException		Devuelve error en caso de no poder escribir los datos en el fichero
	 * 	@see Usuario_comp
	 */
	public void guardarUsuario(Usuario_comp u) throws IOException {
		FileWriter fw = new FileWriter (dataUsers,true);
		PrintWriter pr = new PrintWriter(fw);
		pr.print(u.nombre);
		pr.print(" ");
		pr.print(u.password);
		pr.print(" ");
		pr.close();
	}
	/**
	 * 	Realiza un inicio de sesion en el programa	
	 * 	<p>
	 * 		El usuario queda almacenado en el parametro u
	 * 	</p>
	 * 	@param	u	El usuario con el cual queremos acceder, servira para recuperar el valor de respuesta
	 * 	@throws	FileNotFoundException		El fichero no existe/Ruta no valida
	 * 	@see Usuario_comp
	 * 
	 */
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

	/**
	 * 	Comprueba la existencia un usuario buscandolo en en el fichero de usuarios 
	 * 
	 * 	@param	u	El usuario con el cual queremos acceder, servira como puntero
	 * 	@return	true en caso de que exista el usuario, false en caso contrario
	 * 	@throws	FileNotFoundException		El fichero no existe/Ruta no valida
	 * 	@see Usuario_comp
	 * 
	 */
	public boolean usuarioExiste(Usuario_comp u) throws FileNotFoundException {
		boolean b=false;
		File archivo= new File("dataUser");
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

	/**
	 * 	Comprueba la existencia un usuario buscandolo en en el fichero de usuarios 
	 * 
	 * 	@param	n El tama&ntilde;o del tablero
	 * 	@return	Devuelve un tablero valido de los que hay almacenados
	 * 
	 * 	@throws	FileNotFoundException		El fichero no existe/Ruta no valida
	 * 	@see	Usuario_comp
	 * 
	 */	
	public Tablero leerTablero(int n) throws FileNotFoundException{
		Tablero t= new Tablero(n,1);
		Algoritmo a= new Algoritmo();
		File archivo = new File(dataTableros);
		Scanner s = new Scanner(archivo);
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				int valor=s.nextInt();
				t.setValorTauler(i, j, valor);
				if (valor != 0) {
					t.setCandidatsTauler(i, j, new boolean[n+1]);
					a.actualizarPosiblesValorEscrito(i,j,valor,t);
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
	/**
	 * 	Proceso para crear un nuevo usuario
	 * 	
	 * 	@param u	El usuario que se desea crear
	 * 	@throws	IOException		Devuelve error en caso de no poder escribir los datos en el fichero
	 * 	@throws	FileNotFoundException		El fichero no existe/Ruta no valida
	 */
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
	
	/**
	 * 	Comprueba si un nombre de usuario existe en el fichero
	 * 	@param	nombre	Nombre de usuario que se desea comprobar
	 * 	@return true si el nombre exisitia con anterioriedad, falso en caso contrario
	 * 	@throws	FileNotFoundException		El fichero no existe/Ruta no valida
	 */
	
	public boolean existeNombre(String nombre) throws IOException {
		boolean b=false;
		File archivo= new File(dataUsers);
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