package dominio;

public class MyEntry {

    private String component1;
    private Integer component2;

    public MyEntry() {
    }

    public MyEntry(String component1, Integer component2) {
            this.component1 = component1;
            this.component2 = component2;
    }

    public String fst() {
            return component1;
    }

    public void setComponent1(String component1) {
            this.component1 = component1;
    }

    public Integer snd() {
            return component2;
    }

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