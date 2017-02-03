package grid.model;

public class Matrix
{
	private Double[][] matrix;
	private int mainRow;
	private int mainCol;

	public Matrix(Double[][] matrix)
	{
		this.matrix = matrix;
		System.out.println(matrix[0][0]);
		this.mainRow = matrix[0].length - 1;
		this.mainCol = matrix.length - 1;
		//System.out.println(matrix);
	}

	public Matrix(String[][] displayMatrix)
	{
		this.matrix = this.makeMatrix(displayMatrix);
		this.mainRow = matrix.length - 1;
		this.mainCol = matrix[0].length - 1;
	}

	public void setEntry(int row, int col, double data)
	{
		matrix[row][col] = data;
	}

	public double getEntry(int row, int col)
	{
		return matrix[row][col];
	}

	public String[][] getDisplayMatrix()
	{
		String[][] displayMatrix = new String[mainRow][mainCol + 1];
		for (int row = 0; row < displayMatrix.length; row++)
		{
			for (int col = 0; col < displayMatrix[0].length; col++)
			{
				if (col == (displayMatrix[0].length - 1))
				{
					displayMatrix[row][col] = Double.toString(matrix[row][mainCol]);
				} else if (col == displayMatrix[0].length - 2)
				{
					displayMatrix[row][col] = "=";
				} else
				{
					displayMatrix[row][col] = Double.toString(matrix[row][col]);
				}
			}
		}
		return displayMatrix;
	}

	private Double[][] makeMatrix(String[][] displayMatrix)
	{
		Double[][] matrix = new Double[displayMatrix.length - 1][displayMatrix[0].length];
		System.out.println((displayMatrix.length-2)+","+(displayMatrix[0].length - 1));
		for (int row = 0; row < displayMatrix.length; row++)
		{
			for (int col = 0; col < displayMatrix[0].length; col++)
			{
				System.out.println(col+","+row);
				if (col == (displayMatrix[0].length - 2))
				{
					System.out.println("hi");
					matrix[row][col - 1] =
							Double.parseDouble(displayMatrix[row][col]);
				} else if (col == displayMatrix[0].length - 1)
				{

				} else
				{
					matrix[row][col] = 
							Double.parseDouble(displayMatrix[row][col]);
				}
			}
		}
		return matrix;
	}
	public int getRow()
	{
		return mainRow;
	}

	public int getCol()
	{
		return mainCol;
	}

}
