import org.junit.*;
import static org.junit.Assert.*;

public class MatrixTest {
	
	@Test
	public void testAdd() {
		
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(1));
		Matrix<Rational> rm2 = new Matrix<Rational>(2,2, new Rational(3));
		rm1.add(new Matrix<Rational>(2,2, new Rational(2)));
		
		assertEquals(rm1, rm2);
		
		
		Matrix<MatrixDouble> dm1 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(1.0));
		Matrix<MatrixDouble> dm2 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(3.0));
		dm1.add(new Matrix<MatrixDouble>(2,2, new MatrixDouble(2.0)));
		
		assertEquals(dm1, dm2);
	}
	
	@Test(expected = IncompatibleMatrixException.class)
	public void testAddWithDifferentNumberOfRows(){
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(1));
		rm1.add(new Matrix<Rational>(1,2, new Rational(2)));
	}
	
	@Test
	public void testSubtract(){
		
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(2));
		Matrix<Rational> rm2 = new Matrix<Rational>(2,2, new Rational(1));
		rm1.subtract(new Matrix<Rational>(2,2, new Rational(1)));
		
		assertEquals(rm1, rm2);
		
		
		Matrix<MatrixDouble> dm1 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(2.0));
		Matrix<MatrixDouble> dm2 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(1.0));
		dm1.subtract(new Matrix<MatrixDouble>(2,2, new MatrixDouble(1.0)));
		
		assertEquals(dm1, dm2);
	}
	
	@Test(expected = IncompatibleMatrixException.class)
	public void testSubtractWithDifferentNumberOfRows(){
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(2));
		rm1.subtract(new Matrix<Rational>(1,2, new Rational(1)));
	}
	
	@Test
	public void testMultiply(){
		
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(2));
		rm1.multiply(new Rational(2));
		
		assertEquals(rm1, new Matrix<Rational>(2,2, new Rational(4)));
		
		Matrix<MatrixDouble> dm1 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(2.0));
		dm1.multiply(new MatrixDouble(2.0));
		
		assertEquals(dm1, new Matrix<MatrixDouble>(2,2, new MatrixDouble(4.0)));
	}
	
	@Test
	public void testTransposeSquareMatrix(){
		
		Matrix<Rational> m1 = new Matrix<Rational>(2,2, new Rational(0));
		
		m1.setAt(0, 0, new Rational(2));
		m1.setAt(0, 1, new Rational(1));
		m1.setAt(1, 0, new Rational(3));
		m1.setAt(1, 1, new Rational(4));
		
		Matrix<Rational> m2 = new Matrix<Rational>(2,2, new Rational(0));
		
		m2.setAt(0,  0, new Rational(2));
		m2.setAt(0, 1, new Rational(3));
		m2.setAt(1,0, new Rational(1));
		m2.setAt(1, 1, new Rational(4));
		
		m1.transpose();
		
		assertEquals(m1, m2);
	}
	
	@Test
	public void testTransposeNonSquareMatrix(){
		
		Matrix<Rational> m1 = new Matrix<Rational>(3,2, new Rational(0));
		
		m1.setAt(0, 0, new Rational(1));
		m1.setAt(0, 1, new Rational(2));
		m1.setAt(1, 0, new Rational(3));
		m1.setAt(1, 1, new Rational(4));
		m1.setAt(2, 0, new Rational(5));
		m1.setAt(2, 1, new Rational(6));
		
		Matrix<Rational> m2 = new Matrix<Rational>(2,3, new Rational(0));
		
		m2.setAt(0, 0, new Rational(1));
		m2.setAt(0, 1, new Rational(3));
		m2.setAt(0, 2, new Rational(5));
		m2.setAt(1, 0, new Rational(2));
		m2.setAt(1, 1, new Rational(4));
		m2.setAt(1, 2, new Rational(6));
		
		m1.transpose();

		assertEquals(m1, m2);
	}
	
	@Test
	public void testNegate(){
		
		Matrix<Rational> rm1 = new Matrix<Rational>(2,2, new Rational(1));
		
		rm1.negate();
		
		assertEquals(rm1, new Matrix<Rational>(2,2, new Rational(-1)));
		
		Matrix<MatrixDouble> dm1 = new Matrix<MatrixDouble>(2,2, new MatrixDouble(1.0));
		
		dm1.negate();
		
		assertEquals(dm1, new Matrix<MatrixDouble>(2,2, new MatrixDouble(-1.0)));
		
	}
	

}
