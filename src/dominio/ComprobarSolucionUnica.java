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
		solve(0, 0, aux);
		
		return true;
	}


	/** Checks if num is an acceptable value for the given row */
	protected boolean checkRow( int row, int num, int[][] t )
	{
		for( int col = 0; col < 9; col++ )
			if( t[row][col]== num )
				return false ;

		return true ;
	}

	/** Checks if num is an acceptable value for the given column */
	protected boolean checkCol( int col, int num, int[][] t )
	{
		for( int row = 0; row < 9; row++ )
			if( t[row][col] == num )
				return false ;

		return true ;
	}

	/** Checks if num is an acceptable value for the box around row and col */
	protected boolean checkBox( int row, int col, int num, int[][] t )
	{
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;

		for( int r = 0; r < 3; r++ )
			for( int c = 0; c < 3; c++ )
				if( t[row][col] == num )
					return false ;

		return true ;
	}
	public void solve( int row, int col, int[][] t ) throws Exception
	{
		// Throw an exception to stop the process if the puzzle is solved
		if( row > 8 )
			throw new Exception( "Solution found" ) ;

		// If the cell is not empty, continue with the next cell
		if( t[row][col] != 0 )
			next( row, col,t ) ;
		else
		{
			// Find a valid number for the empty cell
			for( int num = 1; num < 10; num++ )
			{
				if( checkRow(row,num,t) && checkCol(col,num,t) && checkBox(row,col,num,t) )
				{
					t[row][col] = num;;

					// Delegate work on the next cell to a recursive call
					next( row, col,t ) ;
				}
			}

			// No valid number was found, clean up and return to caller
			t[row][col] = 0;; ;
		}
	}

	/** Calls solve for the next cell */
	public void next( int row, int col, int[][] t) throws Exception
	{
		if( col < 8 )
			solve( row, col + 1, t ) ;
		else
			solve( row + 1, 0, t ) ;
	}
}
