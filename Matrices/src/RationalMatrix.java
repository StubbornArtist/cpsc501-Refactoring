
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
	 * Constructor which initializes this array with the values and size of a
	 * given array
	 * 
	 * @param matrix
	 */
	public RationalMatrix(Rational[][] matrix) {
		this.matrix = new Rational[matrix.length][matrix[0].length];
		setMatrix(matrix);
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other
	 */
	public RationalMatrix(RationalMatrix other) {
		this(other.getMatrix());

	}

	/**
	 * Takes two rational matrices and adds the values of their rational numbers
	 * at each position and places these values in a new matrix at the same
	 * positions.
	 * 
	 * @param m1
	 *            the first rational matrix
	 * @param m2
	 *            the second rational matrix
	 * @return RationalMatrix matrix with sum of values in m1 and m2
	 */
	public static RationalMatrix add(RationalMatrix m1, RationalMatrix m2) {

		RationalMatrix temp = null;
		// checks if the row and column length of the two matrices is the same
		if (m1.rowLength() != m2.rowLength()){
			System.out.println("Incompatible for addition");
			System.exit(0);
		} else {
			// creates new rational matrix of the same dimensions
			temp = new RationalMatrix(m1.rowLength(), m1.colLength());
			// adds the rational numbers from each matrix at the same position
			for (int h = 0; h < m1.rowLength(); h++) {
				for (int i = 0; i < m1.colLength(); i++) {
					temp.setAt(h, i,
							Rational.add(m1.getAt(h, i), m2.getAt(h, i)));
				}
			}
		}

		return temp;
	}

	/**
	 * Takes two rational matrices and subtracts the values of the second
	 * matrices rational numbers at each position from those of the first and
	 * places these values in a new matrix at the same positions.
	 * 
	 * @param m1
	 *            the first rational matrix
	 * @param m2
	 *            the second rational matrix
	 * @return RationalMatrix matrix with the difference of the rationals in m1
	 *         and m2
	 */
	public static RationalMatrix subtract(RationalMatrix m1, RationalMatrix m2) {

		RationalMatrix temp = null;
		// checks if the row and column length of the two matrices is the same
		if (m1.rowLength() != m2.rowLength()
				|| m1.colLength() != m2.colLength()) {
			
			System.out.println("Incompatible for subtraction");
			System.exit(0);
		
		} else {
			// creates new rational matrix of the same dimensions
			temp = new RationalMatrix(m1.rowLength(), m1.colLength());
			// subtracts the rational numbers from each matrix at the same
			// position
			for (int h = 0; h < m1.rowLength(); h++) {
				for (int i = 0; i < m1.colLength(); i++) {
					temp.setAt(h, i,
							Rational.subtract(m1.getAt(h, i), m2.getAt(h, i)));
				}
			}
		}

		return temp;
	}

	/**
	 * Takes a rational number (scalar value) and a rational matrix. Gets the
	 * product of the scalar with every element and places the product at the
	 * same position in a new matrix
	 * 
	 * @param m
	 *            rational matrix
	 * @param r
	 *            rational number or scalar
	 * @return RationalMatrix matrix with the scalar quantity multiplied by each
	 *         element in m
	 */
	public static RationalMatrix multiply(RationalMatrix m, Rational r) {
		// scalar multiplication
		RationalMatrix temp = null;
		// creates new rational matrix of the same dimensions
		temp = new RationalMatrix(m.rowLength(), m.colLength());
		// multiplies the rational number at each position in the matrix by the
		// scalar
		for (int h = 0; h < m.rowLength(); h++) {
			for (int i = 0; i < m.colLength(); i++) {
				temp.setAt(h, i, Rational.multiply(m.getAt(h, i), r));
			}
		}

		return temp;
	}

	/**
	 * Takes a rational matrix and transposes it. The given matrix does not have
	 * to be a square matrix.
	 * 
	 * @param m
	 *            a rational matrix
	 * @return RationalMatrix the transposition of the given matrix
	 */

	public static RationalMatrix transpose(RationalMatrix m) {
		// creates a rational matrix of reversed dimensionality
		RationalMatrix temp = new RationalMatrix(m.colLength(), m.rowLength());
		// takes a value from matrix m at each position (h,i)
		// and places it in the temporary matrix at (i,h)
		for (int h = 0; h < m.rowLength(); h++) {
			for (int i = 0; i < m.colLength(); i++) {

				temp.setAt(i, h, new Rational(m.getAt(h, i)));

			}
		}
		return temp;

	}

	/**
	 * Takes a rational matrix and multiplies every element by -1.
	 * 
	 * @param m
	 *            a rational matrix
	 * @return RationalMatrix the negation of the original matrix
	 */
	public static RationalMatrix negate(RationalMatrix m) {
		RationalMatrix temp = null;
		// creates new rational matrix of the same dimensions
		temp = new RationalMatrix(m.rowLength(), m.colLength());
		// negates every element
		for (int h = 0; h < m.rowLength(); h++) {
			for (int i = 0; i < m.colLength(); i++) {
				temp.setAt(h, i, Rational.negate(m.getAt(h, i)));
			}
		}

		return temp;
	}

	/**
	 * Takes a rational matrix and adds it's values to those of this matrix
	 * 
	 * @param m
	 *            a rational matrix
	 */
	public void add(RationalMatrix m) {
		this.setMatrix(add(this, m).getMatrix());

	}

	/**
	 * Takes a rational matrix and subtracts it's values from those of this
	 * matrix
	 * 
	 * @param m
	 *            a rational matrix
	 */
	public void subtract(RationalMatrix m) {
		setMatrix(subtract(this, m).getMatrix());
	}

	/**
	 * Takes a rational number and multiplies every element in this matrix by
	 * that rational
	 * 
	 * @param r
	 *            rational number
	 */
	public void multiply(Rational r) {
		setMatrix(multiply(this, r).getMatrix());
	}

	/**
	 * Transposes this matrix using the static transpose method
	 */
	public void transpose() {
		matrix = transpose(this).getMatrix();

	}

	/**
	 * Negates this matrix using the static negate method
	 */
	public void negate() {
		setMatrix(negate(this).getMatrix());

	}

	/**
	 * Sets the values of the matrix in RationalMatrix to those in the given
	 * matrix
	 * 
	 * @param 
	 *            rational matrix
	 */
	public void setMatrix(Rational[][] m) {
		// checks if the dimensions of the new matrix are the same as those of
		// the original matrix
		if (m.length != matrix.length || m[0].length != matrix[0].length) {
			System.out.println("Incompatible matrices");
			System.exit(0);
		}
		// places the elements from the given matrix in the original matrix
		for (int h = 0; h < m.length; h++) {
			for (int i = 0; i < m[h].length; i++) {
				this.setAt(h, i, new Rational(m[h][i]));
			}
		}
	}

	/**
	 * Gives a 2d matrix of type rational that is equal to the matrix stored
	 * inside this RationalMatrix
	 * 
	 * @return Rational[][] the rational matrix stored inside of the
	 *         RationalMatrix object
	 */
	public Rational[][] getMatrix() {
		// creates a new matrix of type rational with the same dimensions as
		// this matrix
		Rational[][] temp = new Rational[matrix.length][matrix[0].length];
		// places an element at (h,i) in this matrix in the new matrix at (h,i)
		for (int h = 0; h < matrix.length; h++) {
			for (int i = 0; i < matrix[h].length; i++) {
				temp[h][i] = new Rational(this.getAt(h, i));
			}
		}
		return temp;
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
		boolean same = true;
		// checks it the dimensions of this matrix are the same as the given
		// matrix
		// if not they are not equivalent matrices
		if(other==null){
			return false;
		}
		if(!(other instanceof RationalMatrix)) 
			return false;
		
		if (((RationalMatrix) other).rowLength() != this.rowLength()
				|| ((RationalMatrix)other).colLength() != this.colLength()) {
			same = false;
		} else {
			// checks every element at position (h,i) in this matrix and
			// compares it to the
			// element in the given matrix at (h,i)
			for (int h = 0; h < matrix.length; h++) {
				for (int i = 0; i < matrix[h].length; i++) {
					if (!this.getAt(h, i).equals(((RationalMatrix)other).getAt(h, i))) {
						same = false;
					}
				}
			}

		}
		return same;
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

