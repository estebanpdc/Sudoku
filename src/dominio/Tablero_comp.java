package dominio;

public class Tablero_comp {
       
        private Casilla[][] tauler;
        private int mida;
       
        /**
     * Crea un tauler buit
     */
        public Tablero_comp()
        {
                tauler = new Casilla[0][0];
                mida = 0;
        }
       
        /**
         * Crea un tauler de mida NxN
         */
        public Tablero_comp(int N)
        {
                tauler = new Casilla[N][N];
                int i,j;
                for (i = 0; i < N; ++i) {
                        for (j = 0; j < N; ++j) {
                                tauler[i][j] = new Casilla();
                        }
                }
                mida = N;
        }
       
        /**
         * Retorna la mida del tauler
         */
        private int getMida()
        {
                return mida;
        }
       
        /**
         * Retorna el valor de la casella a la posicio
         * x,y del tauler
         */
        private int getValorCasella(int x, int y)
        {
                return tauler[x][y].getValor();
        }
       
        /**
         * Posa n a la casella que hi ha a la posicio
         * x,y del tauler
         */
        private void setValorCasella(int x, int y, int n)
        {
                if (!tauler[x][y].isPor_defecto()) tauler[x][y].setValor(n);
        }
       
        /**
         * Esborra el numero de la casella que hi ha
         * a la posicio x,y del tauler
         */
        private void esborrarValorCasella(int x, int y)
        {
                if (!tauler[x][y].isPor_defecto()) tauler[x][y].setValor(0); //Considerem 0 = casella no te valor
        }
       
        /**
         * Posa n com a candidat de la casella que hi ha
         * a la posicio x,y del tauler
         */
        private void setCandidatCasella(int x, int y, int n)
        {
                tauler[x][y].setCandidat(n);
        }
       
        /**
         * Esborra n dels candidats de la casella que hi
         * ha a la posició x,y del tauler
         */
        private void esborrarCandidatCasella(int x, int y, int n)
        {
                tauler[x][y].esborrarCandidat(n);
        }
}