import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class RationalMatrixTest {
	
	
	@BeforeClass
	public static void setUp(){
		System.setSecurityManager(new SystemExitSecurityManager());	
	}
	
	@Test
	public void testAdd(){
		RationalMatrix m1 = new RationalMatrix(2,2,new Rational(1));
		RationalMatrix m2 = new RationalMatrix(2,2, new Rational(3));
		m1.add(new RationalMatrix(2,2, new Rational(2)));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = SystemExitSecurityException.class)
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
	
	@Test(expected = SystemExitSecurityException.class)
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
		Rational [][] m = {{new Rational(2), new Rational(1)},{new Rational(3), new Rational(4)}};
		Rational [][] mt = {{new Rational(2), new Rational(3)},{new Rational(1), new Rational(4)}};
		RationalMatrix m1 = new RationalMatrix(m);
		m1.transpose();
		
		assertEquals(m1, new RationalMatrix(mt));
	}
	
	@Test
	public void testTransposeNonSquareMatrix(){
		Rational [][] m = {{new Rational(1), new Rational(2)},{new Rational(3), new Rational(4)},
				{new Rational(5), new Rational(6)}};
		Rational [][] mt = {{new Rational(1),new Rational(3),new Rational(5)},
				{new Rational(2),new Rational(4),new Rational(6) }};
		RationalMatrix m1 = new RationalMatrix(m);
		
		m1.transpose();
		
		assertEquals(m1,new RationalMatrix(mt));
	}
	
	@Test
	public void testNegate(){
		RationalMatrix m1 = new RationalMatrix(2,2, new Rational(1));
		
		m1.negate();
		
		assertEquals(m1, new RationalMatrix(2,2, new Rational(-1)));
		
	}
	
}
	
