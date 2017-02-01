package grid.model;

public class Matrix
{
	Integer[][] matrix;
	int mainRow;
	int mainCol;
	public Matrix(Integer[][] matrix)
	{
		this.matrix = matrix;
		this.mainRow = matrix.length-1;
		this.mainCol = matrix[0].length-1;
	}
	public Matrix(String[][] displayMatrix)
	{
		this.matrix = this.makeMatrix(displayMatrix);
		this.mainRow = matrix.length-1;
		this.mainCol = matrix[0].length-1;
	}
	
	public void setEntry(int row, int col,int data)
	{
		matrix[row][col] = data;
	}
	
	public int getEntry(int row, int col)
	{
		return matrix[row][col];
	}
	
	public String[][] getDisplayMatrix()
	{
		String[][] displayMatrix = new String[mainRow][mainCol+1];
		for(int row = 0; row<displayMatrix.length;row++)
		{
			for(int col = 0; col<displayMatrix[0].length;col++)
			{
				if(col==(displayMatrix[0].length-1))
				{
					displayMatrix[row][col]=Integer.toString(matrix[row][mainCol]);
				}
				else if(col==displayMatrix[0].length-2)
				{
					displayMatrix[row][col] = "=";
				}
				else
				{
					displayMatrix[row][col] = Integer.toString(matrix[row][col]);
				}
			}
		}
		return displayMatrix;
	}
	private Integer[][] makeMatrix (String[][] displayMatrix)
	{
		Integer[][] matrix = new Integer[displayMatrix.length-1][displayMatrix[0].length-2];
		for(int row = 0; row<displayMatrix.length;row++)
		{
			for(int col = 0; col<displayMatrix[0].length;col++)
			{
				if(col==(displayMatrix[0].length-1))
				{
					matrix[row][col-1] = Integer.parseInt(displayMatrix[row][col]);
				}
				else if(col==displayMatrix[0].length-2)
				{
					
				}
				else
				{
					matrix[row][col] = Integer.parseInt(displayMatrix[row][col]);
				}
			}
		}
		return matrix;
	}

}

