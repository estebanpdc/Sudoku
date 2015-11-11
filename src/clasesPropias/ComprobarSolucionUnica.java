package clasesPropias;

public class ComprobarSolucionUnica extends Algoritmo{
	private static int[][] board;
	private static int[][] board2;
	public ComprobarSolucionUnica() {}

	public boolean tieneSolucionUnica(Tablero t) throws Exception {
		int mida = t.getMida();
		board = new int[mida][mida];
		board2 = new int[mida][mida];
		for(int i = 0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				board[i][j] = t.getValorTauler(i, j);
				board2[i][j] = t.getValorTauler(i, j);
			}
		}
		int box_size = (int) Math.sqrt(mida);
		guess(0, 0,box_size);
		guess2(mida-1,mida-1,box_size);
		return compararSoluciones(board, board2, mida);
	}
	
	private static boolean check(int num, int row, int col,int box_size) {
		int r = (row / box_size) * box_size;
		int c = (col / box_size) * box_size;
		int tam = box_size * box_size;
		
		for (int i = 0; i < tam; i++) {
			if (board[row][i] == num ||
					board[i][col] == num ||
					board[r + (i % box_size)][c + (i / box_size)] == num){
				return false;
			}
		}
		return true;
	}
	private static boolean check2(int num, int row, int col,int box_size) {
		int r = (row / box_size) * box_size;
		int c = (col / box_size) * box_size;
		int tam = box_size * box_size;
		
		for (int i = 0; i < tam; i++) {
			if (board2[row][i] == num ||
					board2[i][col] == num ||
					board2[r + (i % box_size)][c + (i / box_size)] == num){
				return false;
			}
		}
		return true;
	}
	/*
      Test all candidate numbers for a given cell until the board is complete.
      @param row Cell's row.
      @param col Cell's column.
      @return &lt;false&gt; if no legal numbers are found for this cell.
	 */
	public static boolean guess(int row, int col,int box_size){
		int tam = box_size * box_size;
		int nextCol = (col + 1) % tam;
		int nextRow = row;
		if(nextCol == 0) ++nextRow;
		try {
			if (board[row][col] != 0)
				return guess(nextRow, nextCol,box_size);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return true;
		}
		for (int i = 1; i <= tam; i++) {
			if (check(i, row, col, box_size)) {
				board[row][col] = i;
				if (guess(nextRow, nextCol, box_size)) {
					return true;
				}
			}
		}
		board[row][col] = 0;
		return false;
	}
	
	public static boolean guess2(int row, int col,int box_size){
		int tam = box_size * box_size;
		int nextCol = (col - 1) % tam;
		int nextRow = row;
		if(nextCol == -1  ){
			--nextRow;
			 nextCol=tam-1;
		}
		try {
			if (board2[row][col] != 0)
				return guess2(nextRow, nextCol,box_size);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return true;
		}

		for (int i = tam; i >= 0; --i) {
			if (check2(i, row, col, box_size)) {
				board2[row][col] = i;
				if (guess2(nextRow, nextCol, box_size)) {
					return true;
				}
			}
		}
		board2[row][col] = 0;
		return false;
	}
	
	private static boolean compararSoluciones(int[][] b1, int[][] b2,int mida) {
		boolean b = true;
		for(int i = 0; i < mida; ++i) {
			for(int j = 0; j < mida && b; ++j) {
				if(board[i][j] != board2[i][j]) b = false;
			}
		}
		return b;
	}
}
