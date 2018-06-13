/**
  * This program performs basic matrix operations
  * @Author: Robbie Watling
  * Summer 2018
  */

public class RationalMatrix { 
	Rational[][] matrix;
	
	/**
	 * 
	 */
	public RationalMatrix() {
		matrix = new Rational[1][1];
		matrix[1][1] = new Rational();
	}
	
	/**
	 * Constructor that takes a 2D array of strings
	 * and creates a 2D array of Rationals
	 * @param stringArray
	 */
	public RationalMatrix(String[][] stringArray) {
		matrix = new Rational[stringArray.length][stringArray[0].length];
		
		for(int i = 0; i < stringArray.length; i++) {
			for(int j = 0; j < stringArray.length; j++) {
				String tempString = stringArray[i][j];
				if(tempString.contains("/")) {
					int vinculumIndex = tempString.indexOf("/");
					matrix[i][j] = new Rational(Integer.parseInt(tempString.substring(0,vinculumIndex)), Integer.parseInt(tempString.substring(vinculumIndex + 1)));
				}
			}
		}
	}
	
	/**
	 * Returns the cell's value as a Rational
	 * @param row
	 * @param column
	 * @return cell value
	 * @throws IllegalArgumentException
	 */
	public Rational getCell(int row, int column) {
		if (!validate(row, column))
			return null;
		return matrix[row-1][column-1];
	}
	
	/**
	 * Returns whether the cell exists
	 * @param row
	 * @param column
	 * @return
	 */
	private boolean validate(int row, int column) {
		return !(row <= 0 || column <= 0 || row > matrix.length || column > matrix[0].length);
	}
	
	/**
	 * Returns whether the row exists
	 * @param row
	 * @return
	 */
	private boolean validateRow(int row) {
		return !(row <= 0 || row > matrix.length);
	}
	
	/**
	 * Swaps two valid rows
	 * @param row1
	 * @param row2
	 */
	public void rowSwap(int row1, int row2) {
		if (!(validateRow(row1) && validateRow(row2)))
			return;
		else
			row1 -= 1;
			row2 -= 1;
			Rational[] temp = matrix[row1];
			matrix[row1] = matrix[row2];
			matrix[row2] = temp;
	}
	
	/**
	 * Multiplies row by a constant
	 * @param row
	 */
	public void rowScale(int row, Rational scalar) {
		for(int i = 0; i < matrix[row].length; i++) {
			matrix[row][i] = matrix[row][i].multiply(scalar);
		}
	}
	
	/**
	 * Finds the reduced row echelon form of the matrix
	 * Follows the Gauss-Jordan Algorithm
	 */
	public void rrefSolve() {
		sortRows();
		
		//solves but does not make pivot columns 1
		for (int i = 0; i < matrix.length; i ++) {
			 for (int j = 0; j < matrix.length; j ++) {
				 if (i != j && !matrix[i][i].toString().equals("0")) {
					 Rational mult = matrix[j][i].divide(matrix[i][i]);
					 
					 for (int k = 0; k < matrix[0].length; k++) 
						 matrix[j][k] = matrix[j][k].subtract(matrix[i][k].multiply(mult));
				 }
			 }
		 }
		
		//Reduces pivot columns to 1
		for (int i = 0; i < matrix.length; i++) {
			if (!matrix[i][i].toString().equals("0")) {
				Rational pivot = matrix[i][i];
				rowScale(i, pivot.getReciporical());
			}
		}
	}
	
	/**
	 * Puts rows in optimal arrangement for rref calculations
	 */
	private void sortRows() {
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][i].toString().equals("0")) {
				int c = 1;
				while (matrix[i+c][i].toString().equals("0") && (i+c) < matrix.length)
					c++;
				
				if ((i+c) == matrix.length)
					break;
				
				for (int j = 0; j <= matrix.length; j++)
					rowSwap(j, j+c);
			}
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < matrix.length; i++) {
			s = s + "[";
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == 0)
					s = s + matrix[i][j].toString();
				else 
					s = s + "\t" + matrix[i][j].toString();
			}
			s = s + "]\n";
		}
		return s;
	}
}