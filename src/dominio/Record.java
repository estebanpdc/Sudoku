package dominio;
import java.util.ArrayList;
import java.util.Map.Entry;


/**
 * Created by Jesus on 21/10/15.
 */
public class Record {
    private ArrayList<MyEntry<String,Integer>> clasificacion;
    private int nrecords;

    public Record(){
    	this.nrecords = 0;
    	clasificacion = new ArrayList<MyEntry<String,Integer>>();
    }
    public Record(MyEntry<String,Integer> clasif[], int nrecords){
        this.clasificacion = clasif;
        this.nrecords = nrecords;
    }

    public void setClasificacion(MyEntry<String,Integer> clasif) {
    	
    }
    
    public MyEntry<String,Integer>[] getClasificacion() {
    	return clasificacion;
    }
    
 
    
}
