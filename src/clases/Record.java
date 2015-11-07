package clases;
import javafx.util.Pair;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Jesus on 21/10/15.
 */
public class Record {
    private SortedMap<Integer, String> clasificacion;


    public Record(){}
    public Record(SortedMap<Integer,String> clasif){
        this.clasificacion = clasif;
    }

    public void insertarTiempo(String usuario, int tiempo) {
        clasificacion.put(tiempo, usuario);
    }
    public Pair<Integer,String> getTiempo(int posicion) {
        int borrar = 5 - posicion;
        SortedMap<Integer, String> aux = new TreeMap<Integer, String>();
        for (int i  = 0; i < borrar; ++i) {
            Integer auxint = aux.lastKey();
            aux.remove(auxint);
        }
        Integer tiempo = aux.lastKey();
        String usuario = aux.get(tiempo);
        Pair<Integer,String> ret = new Pair<Integer,String>(tiempo, usuario);
        return ret;
    }
    public ArrayList<Pair<Integer, String>> getTop5() {
        ArrayList<Pair<Integer,String>> ret = new ArrayList<Pair<Integer,String>>();
        SortedMap<Integer, String> aux = new TreeMap<Integer, String>();
        Integer auxint;
        String usuario;
        Integer tam = aux.size();
	        for (int i  = 0; i < tam; ++i) {
	            auxint = aux.lastKey();
	            usuario = aux.get(auxint);
	            Pair<Integer, String> auxpair = new Pair<Integer,String> (auxint, usuario);
	            ret.add(tam-i,auxpair);
	            aux.remove(auxint);
	            //Falta controlar que pasa si hay menos de 5 records
	        }
        
        return ret;
    }
}
