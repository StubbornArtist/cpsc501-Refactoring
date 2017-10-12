import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class RationalMatrixTest {
		
	@Test
	public void testAdd(){
		RationalMatrix m1 = new RationalMatrix(2,2,new Rational(1));
		RationalMatrix m2 = new RationalMatrix(2,2, new Rational(3));
		m1.add(new RationalMatrix(2,2, new Rational(2)));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = IncompatibleMatrixException.class)
	public void testAddWithDifferentNumberOfRows(){
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(1));
		m1.add(new RationalMatrix(1,2, new Rational(2)));
	}
	
	@Test
	public void testSubtract(){
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(2));
		RationalMatrix m2 = new RationalMatrix(2,2, new Rational(1));
		m1.subtract(new RationalMatrix(2,2, new Rational(1)));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = IncompatibleMatrixException.class)
	public void testSubtractWithDifferentNumberOfRows(){
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(2));
		m1.subtract(new RationalMatrix(1,2, new Rational(1)));
	}
	
	@Test
	public void testMultiply(){
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(2));
		m1.multiply(new Rational(2));
		
		assertEquals(m1, new RationalMatrix(2,2, new Rational(4)));
	}

	@Test
	public void testTransposeSquareMatrix(){
		
		RationalMatrix m1 = new RationalMatrix(2,2);
		
		m1.setAt(0, 0, new Rational(2));
		m1.setAt(0, 1, new Rational(1));
		m1.setAt(1, 0, new Rational(3));
		m1.setAt(1, 1, new Rational(4));
		
		RationalMatrix m2 = new RationalMatrix(2,2);
		
		m2.setAt(0,  0, new Rational(2));
		m2.setAt(0, 1, new Rational(3));
		m2.setAt(1,0, new Rational(1));
		m2.setAt(1, 1, new Rational(4));
		
		m1.transpose();
		
		assertEquals(m1, m2);
	}
	
	@Test
	public void testTransposeNonSquareMatrix(){
		
		RationalMatrix m1 = new RationalMatrix(3,2);
		
		m1.setAt(0, 0, new Rational(1));
		m1.setAt(0, 1, new Rational(2));
		m1.setAt(1, 0, new Rational(3));
		m1.setAt(1, 1, new Rational(4));
		m1.setAt(2, 0, new Rational(5));
		m1.setAt(2, 1, new Rational(6));
		
		RationalMatrix m2 = new RationalMatrix(2,3);
		
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
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(1));
		
		m1.negate();
		
		assertEquals(m1, new RationalMatrix(2,2, new Rational(-1)));
		
	}
	
}
	
