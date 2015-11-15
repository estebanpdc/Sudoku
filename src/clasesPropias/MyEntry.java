package clasesPropias;
/**
 * 	Define las entradas de los Records	
 * 
 * 	@author Grup 45 Sudoku
 * 	@version 1.0
 * 	@since 13-11-2015
 * 	@see Record
 */
public class MyEntry {
	/**
	 * 	Cadena de caracteres que almacenan un nombre
	 */
    private String component1;
    /**
     * Valor integer menor que cero que almacena los mejores tiempos
     */
    private Integer component2;
    
    /**
     * Constructora por defecto
     */
    public MyEntry() {
    }
    /**
     * 	Constructora que define tanto el primer componente (Usuario) como el segundo componente (Tiempo)
     * 	@param	component1	Usuario a insertar
     * 	@param	component2	Tiempo a insertar
     */
    public MyEntry(String component1, Integer component2) {
            this.component1 = component1;
            this.component2 = component2;
    }
    /**
     * 	Devuelve el primer componente (Usuario)
     * 	@return	Primer compontente de la entrada
     */
    public String fst() {
            return component1;
    }
    /**
     * 	Cambia el valor del primer componente por uno nuevo
     * 	@param	component1	El nuevo valor para el primer componente
     */
    public void setComponent1(String component1) {
            this.component1 = component1;
    }

    /**
     * 	Devuelve el segundo componente (Tiempo)
     * 	@return	Segundo compontente de la entrada
     */
    public Integer snd() {
            return component2;
    }

    /**
     * 	Cambia el valor del segundo componente por uno nuevo
     * 	@param	component2	El nuevo tiempo para el segundo componente
     */
    public void setComponent2(Integer component2) {
            this.component2 = component2;
    }
    
    /*
    @Override
    public String toString() {
            return "<" + component1 + "," + component2 + ">";
    }

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result
                            + ((component1 == null) ? 0 : component1.hashCode());
            result = prime * result
                            + ((component2 == null) ? 0 : component2.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            final MyEntry<?, ?> other = (MyEntry<?, ?>) obj;
            if (component1 == null) {
                    if (other.component1 != null)
                            return false;
            } else if (!component1.equals(other.component1))
                    return false;
            if (component2 == null) {
                    if (other.component2 != null)
                            return false;
            } else if (!component2.equals(other.component2))
                    return false;
            return true;
    }

    public static <A, B> MyEntry<A, B> create(A component1, B component2) {
            return new MyEntry<A, B>(component1, component2);
    }*/
}