package grid.model;

public class MatrixSolver
{
	Matrix matrix;
	MatrixSolver(Matrix matrix)
	{
		this.matrix = matrix;
	}
	
	public Matrix solve()
	{
		if()
		Matrix solved = matrix;
		
		return solved;
	}
	private void solveCol(int col)
	{
		for(int row = 0; row<=matrix.getRow(); row++)
		{
			if(col==row){}
		}
		
	}

	private boolean isSolvable()
	{
		return (matrix.getCol()<=matrix.getRow());
	}
	
	private void makeSquare()
	{
		Integer[][] squareData = new Integer[matrix.getRow()][matrix.getCol()];
		if(matrix.getCol()<matrix.getRow())
		{
			
			for(int row = 0; row<matrix.getCol(); row++)
			{
				for(int col = 0; col<matrix.getCol(); col++)
				{
					squareData[row][col] = matrix.getEntry(row, col);
				}
			}
		}
		matrix = new Matrix(squareData);
	}
}
