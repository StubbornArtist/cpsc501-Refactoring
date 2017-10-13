
public class Matrix<T extends MatrixCell<T> & DeepClonable<T>> {

	private Array2D<T> matrix;
	
	public Matrix(int rows, int columns) {
		matrix = new Array2D(rows, columns);
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
	public Matrix(int rows, int columns, T initial) {
		matrix = new Array2D<T>(rows, columns);
		// takes values from given array and sets them at the same position in
		// this object's array
		for (int h = 0; h < rows; h++) {
			for (int i = 0; i < columns; i++) {
				setAt(h, i, initial.deepClone());
			}
		}
	}

	/**
	 * Copy Constructor
	 * 
	 * @param other
	 */
	public Matrix(Matrix<T> other) {
		matrix = new Array2D<T>(other.rowLength(), other.colLength());
		
		for(int i = 0; i < other.rowLength(); i++) {
			for(int j = 0; j < other.colLength(); j++) {
				setAt(i, j, other.getAt(i, j));
			}
			
		}
	}
	
	/**
	 * Takes a matrix and adds it's values to those of this matrix
	 * 
	 * @param m
	 *            a matrix
	 */
	public void add(Matrix<T> m) {
		// checks if the row and column length of the two matrices is the same
		if (incompatibleDimensions(m)){
			
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// adds the rational numbers from each matrix at the same position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				T sum = getAt(h, i);
				sum.add(m.getAt(h, i));
				setAt(h, i, sum);
			}
		}
	}

	/**
	 * Takes a matrix and subtracts it's values from those of this
	 * matrix
	 * 
	 * @param m
	 *            a matrix
	 */
	public void subtract(Matrix<T> m) {
		if (incompatibleDimensions(m)) {
			
			throw new IncompatibleMatrixException("Incompatible dimensions");
		} 
		// subtracts the rational numbers from each matrix at the same
		// position
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				T diff = getAt(h,i);
				diff.subtract(m.getAt(h, i));
				setAt(h, i, diff);
			}
		}

	}

	/**
	 * Takes a matrix member and multiplies every element in this matrix by
	 * that rational
	 * 
	 * @param r
	 *            matrix member
	 */
	public void multiply(T r) {
		// multiplies the rational number at each position in the matrix by the
		// scalar
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				T prod = getAt(h,i);
				prod.multiply(r);
				setAt(h, i, prod);
			}
		}
	}

	/**
	 * Transposes this matrix using the static transpose method
	 */
	public void transpose() {
		Array2D<T> temp = new Array2D<T>(colLength(), rowLength()); 
		// takes a value from matrix m at each position (h,i)
		// and places it in the temporary matrix at (i,h)
		for (int h = 0; h < colLength(); h++) {
			for (int i = 0; i < rowLength(); i++) {
				temp.set(h, i, getAt(i,h));
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
				T neg = getAt(h,i);
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
	public boolean incompatibleDimensions(Matrix<T> m) {
		
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
	public void setAt(int row, int column, T r) {
		matrix.set(row, column, r);
	}

	/**
	 * Gives the matrix cell at the specified position in the
	 * matrix
	 * 
	 * @param row
	 *            the position in the row
	 * @param column
	 *            the position in the column
	 * @return T the matrix cell at the specified index
	 */
	public T getAt(int row, int column) {
		return matrix.get(row, column).deepClone();
	}

	/**
	 * Gives the number of columns in the matrix
	 * 
	 * @return int column length
	 */
	public int colLength() {
		return matrix.columns();
	}

	/**
	 * Gives the number of rows in the matrix
	 * 
	 * @return int row length
	 */
	public int rowLength() {
		return matrix.rows();
	}

	/**
	 * Compares this matrix to any given matrix
	 * 
	 * @param other
	 *            another matrix
	 * @return boolean if both matrices have the same values at the same
	 *         positions the n it returns true
	 */
	@Override
	public boolean equals(Object other) {
		// checks it the dimensions of this matrix are the same as the given
		// matrix
		// if not they are not equivalent matrices
		if(other==null || !(other instanceof Matrix<?>) 
				|| incompatibleDimensions((Matrix<T>) other)){
			
			return false;
		}		
		// checks every element at position (h,i) in this matrix and
		// compares it to the
		// element in the given matrix at (h,i)
		for (int h = 0; h < rowLength(); h++) {
			for (int i = 0; i < colLength(); i++) {
				if (!getAt(h, i).equals(((Matrix<T>)other).getAt(h, i))) {
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	 * Creates a string representation of the matrix
	 * 
	 * @return temp (String)
	 */
	@Override
	public String toString() {
		String temp = "";
		// runs through each row
		for (int h = 0; h < rowLength(); h++) {
			// adds each element in the current row to the string
			for (int i = 0; i < colLength(); i++) {
				temp += getAt(h,i);
				// when the last element has not yet been reached a space is
				// inserted after the element
				if (i != colLength() - 1) {
					temp += " ";
				}

			}
			// starts a new line at the end of the row
			temp += "\n";
		}
		return temp;
	}
}
