/**
 * A class to represent a matrix of doubles. Contains static methods
 * for the addition, subtraction, multiplication (by scalar quantity),
 * transposition, and negation of matrices. Contains non static methods for the
 * addition, subtraction, multiplication(by scalar), transposition, and negation
 * of matrices. Also includes an equals method to test the equality of matrices
 * based upon elements in the matrix, and a method which produces a String
 * representation of the matrix.
 * 
 * 
 * @author Ashley Currie
 * @version 2.0, March 2, 2015
 */
public class DoubleMatrix {

	private double [][] matrix;
	
	/**
	 * constructor that initializes the matrix length and width to given values
	 * and zeros in every position
	 * 
	 * @param rows
	 *            number of rows
	 * @param columns
	 *            number of columns
	 */
	public DoubleMatrix(int rows, int columns) {
		this(rows,columns,0.0); 
	}

	/**
	 * Constructor which initializes matrix length and width and a given value
	 * in every position
	 * 
	 * @param rows
	 *            number of rows
	 * @param columns
	 *            number of columns
	 * @param initial
	 *            double 
	 */

	public DoubleMatrix(int rows, int columns, double initial) {
		matrix = new double [rows][columns];
		// takes values from given array and sets them at the same position in
		// this object's array
		for (int h = 0; h < rows; h++) {
			for (int i = 0; i < columns; i++) {
				this.setAt(h, i, initial);
			}
		}
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other
	 */
	public DoubleMatrix(DoubleMatrix other) {
		matrix = new double[other.rowLength()][other.colLength()];
		
		for(int i = 0; i < other.rowLength(); i++) {
			for(int j = 0; j < other.colLength(); j++) {
				other.setAt(i, j, other.getAt(i, j));
			}
		}
	
	}
	
	/**
	 * Takes a double matrix and adds it's values to those of this matrix
	 * 
	 * @param m
	 *            a double matrix
	 */
	public void add(DoubleMatrix m){
		// checks if the row and column length of the two matrices is the same
		if (incompatibleDimensions(m)){
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// adds the doubles from each matrix at the same position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				setAt(h, i, getAt(h, i) + m.getAt(h, i));
			}
		}

	}

	/**
	 * Takes a double matrix and subtracts it's values from those of this
	 * matrix
	 * 
	 * @param m
	 *            a double matrix
	 */
	public void subtract(DoubleMatrix m) {
		if (incompatibleDimensions(m)) {
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// subtracts the double from each matrix at the same
		// position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				setAt(h, i, getAt(h,i) - m.getAt(h, i));
			}
		}
	}

	/**
	 * Takes a double and multiplies every element in this matrix by
	 * that double
	 * 
	 * @param d
	 *            scalar quantity
	 */
	public void multiply(double d) {
		// multiplies the double at each position in the matrix by the
		// scalar
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				setAt(h, i, getAt(h,i) * d);
			}
		}
	}

	/**
	 * Transposes this matrix using the static transpose method
	 */
	public void transpose() {
		double [][] temp = new double [colLength()][rowLength()];
		// takes a value from matrix m at each position (i,h)
		// and places it in the temporary matrix at (h,i)
		for (int h = 0; h < colLength(); h++) {
			for (int i = 0; i < rowLength(); i++) {
				temp[h][i] = getAt(i,h);
			}
		}
		matrix = temp;
	}

	/**
	 * Negates this matrix using the static negate method
	 */
	public void negate() {
		// negates every element
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				setAt(h, i, - 1* getAt(h,i));
			}
		}
	}
	
	/**
	 * Indicate whether this matrix has the same number of rows and columns as another
	 * @param m 
	 * 			the other matrix to compare with
	 * @return
	 * 			boolean : true or false
	 */
	public boolean incompatibleDimensions(DoubleMatrix m) {
		
		return m.rowLength() != rowLength()
				|| m.colLength() != colLength();
		
	}

	/***
	 * Places a double at the specified position in the double matrix
	 * 
	 * @param row
	 *            the position in the row
	 * @param column
	 *            the position in the column
	 * @param d
	 *            double to be substituted in
	 */
	public void setAt(int row, int column, double d) {
		matrix[row][column] = d;
	}

	/**
	 * Gives the double at the specified position in the double
	 * matrix
	 * 
	 * @param row
	 *            the position in the row
	 * @param column
	 *            the position in the column
	 * @return double the double at the specified index
	 */
	public double getAt(int row, int column) {
		return matrix[row][column];
	}

	/**
	 * Gives the number of columns in the matrix
	 * 
	 * @return int column length
	 */
	public int colLength() {
		return matrix[0].length;
	}

	/**
	 * Gives the number of rows in the matrix
	 * 
	 * @return int row length
	 */
	public int rowLength() {
		return matrix.length;
	}

	/**
	 * Compares this double matrix to any given matrix
	 * 
	 * @param other
	 *            another double matrix
	 * @return boolean if both matrices have the same values at the same
	 *         positions the n it returns true
	 */
	@Override
	public boolean equals(Object other) {
		// checks it the dimensions of this matrix are the same as the given
		// matrix
		// if not they are not equivalent matrices
		if(other == null || !(other instanceof DoubleMatrix) 
				|| incompatibleDimensions((DoubleMatrix)other)) {
			return false;
		}		
		// checks every element at position (h,i) in this matrix and
		// compares it to the
		// element in the given matrix at (h,i)
		for (int h = 0; h < matrix.length; h++) {
			for (int i = 0; i < matrix[h].length; i++) {
				if (this.getAt(h, i) != ((DoubleMatrix)other).getAt(h, i)) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * Creates a string representation of the double matrix
	 * 
	 * @return temp (String)
	 */
	@Override
	public String toString() {
		String temp = "";
		// runs through each row
		for (int h = 0; h < matrix.length; h++) {
			// adds each element in the current row to the string
			for (int i = 0; i < matrix[h].length; i++) {
				temp += matrix[h][i];
				// when the last element has not yet been reached a space is
				// inserted after the element
				if (i != matrix[h].length - 1) {
					temp += " ";
				}

			}
			// starts a new line at the end of the row
			temp += "\n";
		}
		return temp;
	}
}

