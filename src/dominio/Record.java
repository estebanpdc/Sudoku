package dominio;




/**
 * Created by Jesus on 21/10/15.
 */
public class Record {
    private MyEntry[] clasificacion;
    private int nrecords;

    public Record(){
    	this.nrecords = 0;
    	clasificacion = new MyEntry[5];
    }
    public Record(MyEntry clasif[], int nrecords){
        this.clasificacion = clasif;
        this.nrecords = nrecords;
    }

    public void setClasificacion(MyEntry clasif) {
    	if (nrecords < 5) {
    		clasificacion[nrecords]=clasif;
    		++nrecords;
    		sort_i(clasificacion,nrecords);
    	}
    	else {
    		if (clasif.snd() < clasificacion[4].snd()) {
    			clasificacion[4]=clasif;
    			sort_i(clasificacion, nrecords);
    		}
    	}
    	
    }
    
    public int getNrecords(){
    	return nrecords;
    }
    
    public void setnrecords(int n){
    	nrecords = n;
    }
    
    public MyEntry[] getClasificacion() {
    	return clasificacion;
    }
   
    

	private static void sort_i(MyEntry[] m, int nrecords){
    	boolean fin=true;
    	int i=nrecords-1;
    	while( fin && i>0){
    		
    		if(m[i].snd()<m[i-1].snd()) {
    			swap(m[i],m[i-1]);
    			--i;
    		}
    		else fin=false;
    	}
    }
	
    private static void swap(MyEntry a, MyEntry b){
    	int auxI=a.snd();
    	String auxS= a.fst();
    	a.setComponent1(b.fst());
    	a.setComponent2(b.snd());
    	b.setComponent1(auxS);
    	b.setComponent2(auxI);
 
    }
    
}
