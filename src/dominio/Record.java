package dominio;
import java.util.Map.Entry;


/**
 * Created by Jesus on 21/10/15.
 */
public class Record {
    private Entry<String,Integer> clasificacion[];


    public Record(){}
    public Record(Entry<String,Integer> clasif[]){
        this.clasificacion = clasif;
    }

    public void setClasificacion(Entry<String,Integer> clasif[]) {
       this.clasificacion = clasif;
    }
    
    public Entry<String,Integer>[] getClasificacion() {
    	return clasificacion;
    }
    
 
    
}
