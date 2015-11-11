package dominio;

public class ComprobarSolucionUnica extends Algoritmo{
	public ComprobarSolucionUnica() {}

	public boolean tieneSolucion(Tablero t) throws Exception {
		int mida = t.getMida();
		int aux[][] = new int[mida][mida];
		int aux2[][] =  new int[mida][mida];
		for(int i = 0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				aux[i][j] = t.getValorTauler(i, j);
				aux2[i][j] = t.getValorTauler(i, j);
			}
		}
		for(int i = 0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				System.out.print(aux[i][j]);
			}
		}
		System.out.println("");
		solve(0, 0, aux);

		for(int i = 0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				System.out.print(aux[i][j]);
			}
		}
		return true;
	}
	
	private boolean solve(int i, int j, int[][] sudoku) {
		if(i > 8) {
			return true;
		}
		if(sudoku[i][j] == 0) {
			for(int var = 1; var < 10; var++) {
				if(checkFill(i, j, var, sudoku)) {
					sudoku[i][j] = var;
					if(j >= 8) {
						solve(i + 1, 0, sudoku);
					} else {
						solve(i, j+1, sudoku);
					}
				}
			}
		} else {
			if(j >= 8) {
				solve(i + 1, 0, sudoku);
			} else {
				solve(i, j+1, sudoku);
			}
		}
		return false;
	}
	
	private boolean checkFill(int i, int j, int var, int[][] sudoku) {
        for(int a = 0; a < 9; a++) {
            if(sudoku[a][j] == var) {
                return false;
            }
        }
        for(int a = 0; a < 9; a++) {
            if(sudoku[i][a] == var) {
                return false;
            }
        }
        int tempI = (i / 3) * 3;
        int tempJ = (j / 3) * 3;
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                if(sudoku[tempI + a][tempJ + b] == var)
                    return false;
            }
        }
        return true;
    }
}
