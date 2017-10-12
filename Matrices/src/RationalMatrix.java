/**
 * A class to represent a matrix of rational numbers. Contains static methods
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

public class RationalMatrix {

	// instance variables
	private Rational[][] matrix;

	/**
	 * constructor that initializes the matrix length and width to given values
	 * and zeros in every position
	 * 
	 * @param rows
	 *            number of rows
	 * @param columns
	 *            number of columns
	 */
	public RationalMatrix(int rows, int columns) {
		this(rows,columns,new Rational()); 
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
	 *            rational number
	 */

	public RationalMatrix(int rows, int columns, Rational initial) {
		matrix = new Rational[rows][columns];
		// takes values from given array and sets them at the same position in
		// this object's array
		for (int h = 0; h < rows; h++) {
			for (int i = 0; i < columns; i++) {
				this.setAt(h, i, new Rational(initial));
			}
		}
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other
	 */
	public RationalMatrix(RationalMatrix other) {
		matrix = new Rational[other.rowLength()][other.colLength()];
		
		for(int i = 0; i < other.rowLength(); i++) {
			for(int j = 0; j < other.colLength(); j++) {
				other.setAt(i, j, other.getAt(i, j));
			}
		}

	}

	/**
	 * Takes a rational matrix and adds it's values to those of this matrix
	 * 
	 * @param m
	 *            a rational matrix
	 */
	public void add(RationalMatrix m) {
		// checks if the row and column length of the two matrices is the same
		if (incompatibleDimensions(m)){
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// adds the rational numbers from each matrix at the same position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				Rational sum = getAt(h, i);
				sum.add(m.getAt(h, i));
				setAt(h, i, sum);
			}
		}
	}

	/**
	 * Takes a rational matrix and subtracts it's values from those of this
	 * matrix
	 * 
	 * @param m
	 *            a rational matrix
	 */
	public void subtract(RationalMatrix m) {
		if (incompatibleDimensions(m)) {
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// subtracts the rational numbers from each matrix at the same
		// position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				Rational diff = getAt(h,i);
				diff.subtract(m.getAt(h, i));
				setAt(h, i, diff);
			}
		}

	}

	/**
	 * Takes a rational number and multiplies every element in this matrix by
	 * that rational
	 * 
	 * @param r
	 *            rational number
	 */
	public void multiply(Rational r) {
		// multiplies the rational number at each position in the matrix by the
		// scalar
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				Rational prod = getAt(h,i);
				prod.multiply(r);
				setAt(h, i, prod);
			}
		}
	}

	/**
	 * Transposes this matrix using the static transpose method
	 */
	public void transpose() {
		Rational[][] temp = new Rational[colLength()][rowLength()];
		// takes a value from matrix m at each position (i,h)
		// and places it in the temporary matrix at (h,i)
		for (int h = 0; h < colLength(); h++) {
			for (int i = 0; i < rowLength(); i++) {
				temp[h][i] = getAt(i, h); 
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
				Rational neg = getAt(h,i);
				neg.negate();
				setAt(h, i, neg);
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
	public boolean incompatibleDimensions(RationalMatrix m) {
		
		return m.rowLength() != rowLength()
				|| m.colLength() != colLength();
		
	}

	/***
	 * Places a rational number at the specified position in the rational matrix
	 * 
	 * @param row
	 *            the position in the row
	 * @param column
	 *            the position in the column
	 * @param r
	 *            rational number to be substituted in
	 */
	public void setAt(int row, int column, Rational r) {
		matrix[row][column] = r;
	}

	/**
	 * Gives the rational number at the specified position in the rational
	 * matrix
	 * 
	 * @param row
	 *            the position in the row
	 * @param column
	 *            the position in the column
	 * @return Rational the rational number at the specified index
	 */
	public Rational getAt(int row, int column) {
		return new Rational(matrix[row][column]);
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
	 * Compares this rational matrix to any given matrix
	 * 
	 * @param other
	 *            another rational matrix
	 * @return boolean if both matrices have the same values at the same
	 *         positions the n it returns true
	 */
	@Override
	public boolean equals(Object other) {
		// checks it the dimensions of this matrix are the same as the given
		// matrix
		// if not they are not equivalent matrices
		if(other==null || !(other instanceof RationalMatrix) 
				|| incompatibleDimensions((RationalMatrix) other)){
			
			return false;
		}		
		// checks every element at position (h,i) in this matrix and
		// compares it to the
		// element in the given matrix at (h,i)
		for (int h = 0; h < matrix.length; h++) {
			for (int i = 0; i < matrix[h].length; i++) {
				if (!this.getAt(h, i).equals(((RationalMatrix)other).getAt(h, i))) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * Creates a string representation of the rational matrix
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

