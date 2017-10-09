
/**
 * A class to represent rational numbers. Contains static methods for the
 * addition, subtraction, multiplication, division, reciprocation, and negation
 * of rationals.Contains non static methods for the addition, subtraction,
 * multiplication,division, reciprocation, and negation of rationals. Also
 * includes and equals method to compare the reduced form of any two rational
 * numbers, and a method which creates a String representation of the rational
 * number.
 * 
 * @version 2.0, Mar 02, 2015
 */

public class Rational {

	// instance variables
	private int numerator;
	private int denominator;

	/**
	 * Default constructor: sets the numerator to zero and denominator to 1
	 */
	public Rational() {
		this(0, 1);
	}

	/**
	 * Sets the numerator to the whole number and denominator to 1
	 * 
	 * @param wholeNumber
	 */
	public Rational(int wholeNumber) {
		this(wholeNumber, 1);
	}

	/**
	 * Constructor which sets numerator and denominator to values given
	 * 
	 * @param numerator
	 * @param denominator
	 */
	public Rational(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
		helper();
	}

	/**
	 * Copy Constructor Sets numerator and denominator to values from other
	 * rational object
	 * 
	 * @param other
	 */
	public Rational(Rational other){
		this(other.getNumerator(), other.getDenominator());
	}

	
	/**
	 * Adds any other rational number to this rational number. Utilizes the
	 * static method add
	 * 
	 * @param r
	 *            other rational number
	 */
	public void add(Rational r) {
		// multiplies to get denominator
		int d = getDenominator() * r.getDenominator();
		// computes the numerators to be summed
		int nOne = getNumerator() * r.getDenominator();
		int nTwo = r.getNumerator() * getDenominator();
		// creates new rational object with sum of the rationals given
		setAll(new Rational(nOne + nTwo, d));
	}

	/**
	 * Subtracts any other rational number from this rational number. Utilizes
	 * the static subtract method
	 * 
	 * @param r
	 *            other rational number
	 */
	public void subtract(Rational r) {
		// multiplies to get denominator
		int d = getDenominator() * r.getDenominator();
		// computes the numerators to be subtracted
		int nOne = getNumerator() * r.getDenominator();
		int nTwo = r.getNumerator() * getDenominator();
		// creates new rational object with difference of the rationals given
		setAll(new Rational(nOne - nTwo, d));
	}

	/**
	 * Multiplies any other rational number to this rational number Utilizes the
	 * static multiply method
	 * 
	 * @param r
	 *            other rational number
	 */
	public void multiply(Rational r) {
		setAll(new Rational(getNumerator() * r.getNumerator(),
				getDenominator() * r.getDenominator()));

	}

	/**
	 * Divides this rational number by the given rational number. Utilizes the
	 * static divide method
	 * 
	 * @param r
	 *            other rational number
	 */
	public void divide(Rational r) {
		if(r.equals(new Rational(0))){
			throw new ZeroDenominatorException("Denominator cannot be zero");
		}
		setAll(new Rational(getNumerator() * r.getDenominator(),
				getDenominator() * r.getNumerator()));
	}

	/**
	 * Flips the values of the denominator and numerator to simulate
	 * reciprocating a rational number. Utilizes the static reciprocate static
	 * method
	 */
	public void reciprocate() {
		setAll(new Rational(getDenominator(), getNumerator()));
	}

	/**
	 * Negates this rational number by multiplying the numerator by -1
	 */
	public void negate() {
		setNumerator(numerator * -1);
	}

	// accessor and mutator methods

	/**
	 * Changes the numerator of the rational number. The helper method takes
	 * care of simplifying the fraction once it has been changed
	 * 
	 * @param n
	 *            the new numerator
	 */
	public void setNumerator(int n) {
		numerator = n;
		helper();
	}

	/**
	 * Gives the numerator of the rational
	 * 
	 * @return the numerator of the rational
	 */
	public int getNumerator() {
		return numerator;
	}

	/**
	 * Changes the denominator of the rational number The helper method takes
	 * care of simplifying the fraction once it has been changed
	 * 
	 * @param d
	 *            the new denominator
	 */

	public void setDenominator(int d) {
		denominator = d;
		helper();
	}

	/**
	 * Changes both the numerator and denominator to the values of another
	 * rational
	 * 
	 * @param r
	 *            the new rational number
	 */
	private void setAll(Rational r) {
		numerator = r.getNumerator();
		denominator = r.getDenominator();
		helper();
	}


	/**
	 * Gives the denominator of this rational number
	 * 
	 * @return the denominator of the rational
	 */

	public int getDenominator() {
		return denominator;
	}

	/**
	 * A method which is used after the setting or mutating of the numerator and
	 * denominator. It stops the program if the denominator is zero, because
	 * this is impossible. It is normalized and simplified.
	 */

	private void helper() throws ZeroDenominatorException{
		// denominator cannot be zero
		if (denominator == 0) {
			throw new ZeroDenominatorException("Denominator Cannot be zero");
		}
		normalize();
		//check for the exception of a zero 
		//insure denominator remains 1
		if (numerator == 0) {
			denominator = 1;
		} else {
			// calculate greatest common divisor
			int gcf = gcf();
			// uses computed greatest common divisor to reduce the values and
			// maintain ratio
			numerator = numerator / gcf;
			denominator = denominator / gcf;
		}

	}

	/**
	 * If the denominator is negative then the -1 is brought up to the numerator
	 */
	private void normalize() {
		if (denominator < 0) {
			denominator *= -1;
			numerator *= -1;
		}
	}

	/**
	 * Calculates the greatest common factor of the numerator and denominator
	 * using the Euclidean Algorithm
	 * 
	 * @return int a the greatest common factor of the numerator and denominator
	 */
	private int gcf() {

		int a = Math.abs(numerator);
		int b = Math.abs(denominator);

		if (b > a) {
			a = Math.abs(denominator);
			b = Math.abs(numerator);
		}
		if (b == 0 || a == 0) {
			a = 1;
		}
		// Euclidean Algorithm to find the greatest common divisor of two
		// numbers
		else {
			while (b != 0 && a != 0) {
				int temp = b;
				b = a % b;
				a = temp;

			}
		}
		return a;
	}

	/**
	 * Prints the rational number in String form
	 * 
	 * @return String representation of rational number
	 */
	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}

	/**
	 * Compares the numerators and denominators of this rational and any other
	 * rational If they are the same then it returns true
	 * 
	 * @param other
	 *            another rational object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Rational))
			return false;
		
		return denominator == ((Rational)other).getDenominator()
				&& numerator ==((Rational)other).getNumerator();
	}
}

