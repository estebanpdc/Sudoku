<<<<<<< Updated upstream:src/dominio/Partida_comp.java
package dominio;
=======
package clases;

>>>>>>> Stashed changes:src/clases/Partida_comp.java
/**
 * Creado por el grupo de Sudoku
 */
public class Partida_comp {
	
    private Tablero_comp T;
    private Usuario_comp U;
    private int ID;

    /*Pre: cierto */
    public Partida_comp() {

    }
    /* Post: se crea una partida sin parámetros */

    /*Pre: t, u existen y no están vacíos */
    public Partida_comp(Tablero_comp t, Usuario_comp u, int id) {

    }
    /*Post: se crea una partida con el Tablero t, jugada por el usuario u, y con identificador de partida "id" */


    /*Pre: la partida esta inicializada */
    public static void ayudar() {

    }
    /*Post: se le rellena una casilla del tablero */

    /*Pre: cierto */
    //para borrar, valor = 0;
    public static void modificar_casilla (int i, int j, int valor) {

    }
    /*Post: la casilla de la posicion (i,j) tiene el valor "valor" */

    /*Pre: la partida está inicializada */
    public static void guardar_partida() {

    }
    /*Post: la partida se ha guardado */
}
