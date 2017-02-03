package grid.model;

public class MatrixSolver
{
	Matrix matrix;

	public MatrixSolver(Matrix matrix)
	{
		this.matrix = matrix;
		System.out.println(matrix.getEntry(0, 0));
	}

	public Matrix solve()
	{
		Matrix solved = null;
		if(isSolvable()){
			//System.out.println("solvable");
			
		//makeSquare();
		for (int col = 0; col < matrix.getCol(); col++)
		{
			solveCol(col);
		}
		solved = matrix;
		}
		return solved;
	}

	private void solveCol(int col)
	{
		for (int row = 0; row <= matrix.getRow(); row++)
		{
			if (col == row)
			{
				
				double factor = matrix.getEntry(row, col);
				matrix.setEntry(row, col, 1);
				solveRow(row, row, factor, col);
			} else
			{
				int factorRow = getValidFactorRow(col, row);
				double factor = matrix.getEntry(row, col) / matrix.getEntry(factorRow, col);
				matrix.setEntry(row, col, 0);
				solveRow(row, factorRow, factor, col);
			}
		}

	}

	private void solveRow(int row, int otherRow, double factor, int currentCol)
	{

		for (int col = 0; col <= matrix.getCol(); col++)
		{
			if (col != currentCol)
			{
				if (row == otherRow)
				{
					double newValue = matrix.getEntry(row, col) / factor;
					matrix.setEntry(row, col, newValue);
				} else
				{
					double newValue = matrix.getEntry(row, col) - (matrix.getEntry(otherRow, col) * factor);
					matrix.setEntry(row, col, newValue);
				}

			}
		}

	}

	private boolean isSolvable()
	{
		return (matrix.getRow() <= matrix.getCol());
	}

	private int getValidFactorRow(int col, int rowCurrent)
	{
		int validRow = -1;
		for (int row = 0; row <= matrix.getRow(); row++)
		{
			if (Double.compare(matrix.getEntry(row, col), 0) == 0 && row != rowCurrent)
			{
				validRow = row;
			}
		}
		return validRow;
	}

	private void makeSquare()
	{
		System.out.println(matrix.getEntry(0, 0));
		Double[][] squareData = new Double[matrix.getRow()][matrix.getRow()];
		if (matrix.getCol() < matrix.getRow())
		{

			for (int row = 0; row < matrix.getRow(); row++)
			{
				for (int col = 0; col < matrix.getRow(); col++)
				{
					System.out.println(row+","+col);
					squareData[row][col] = matrix.getEntry(row, col);
				}
			}
			System.out.println(matrix.getEntry(0, 0));
			
		}
		matrix = new Matrix(squareData);
	}
}
