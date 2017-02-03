package grid.controller;

import grid.model.Matrix;
import grid.model.MatrixSolver;

public class Controller
{
	Double[][] matrix;
	public Controller()
	{
//		String[] col1 = {(2),(4),(3)};
//		String[] col2 = {(1),(-2),(5)};
//		String[] col3 = {(3),(1),(-2)};
//		String[] col4 = {"=","=","="};
//		String[] col5 = {(-4),(9),(5)};
//		String[][] matrix = {col1,col2,col3,col4,col5};
//		this.matrix = matrix;
		Double[] col1 = {(double)2,(double) 4,(double)3};
		Double[] col2 = {(double)1,(double)-2,(double)5};
		Double[] col3 = {(double)3,(double)1,(double)-2};
		Double[] col5 = {(double)-4,(double)9,(double)5};
		Double[][] matrix = {col1,col2,col3,col5};
		this.matrix = matrix;
	}
	public void start()
	{
		System.out.println(matrix[0][0]);
		Matrix toSolve = new Matrix(matrix);
		//System.out.println(toSolve);
		MatrixSolver solver = new MatrixSolver(toSolve);
		System.out.println(toSolve.getEntry(0, 0));
		Matrix solved = solver.solve();
		//System.out.println(solved);
	}
}
