import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DoubleMatrixTest {

	@BeforeClass
	public static void setUp(){
		System.setSecurityManager(new SystemExitSecurityManager());	
	}
	
	@Test
	public void testAdd(){
		DoubleMatrix m1 = new DoubleMatrix(2,2, 2.0);
		DoubleMatrix m2 = new DoubleMatrix(2,2, 3.0);
		m1.add(new DoubleMatrix(2,2, 1.0));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void testAddWithDifferentNumberOfRows(){
		DoubleMatrix m1 = new DoubleMatrix(2,2, 1.0);
		m1.add(new DoubleMatrix(1,2, 2.0));
	}
	
	@Test
	public void testSubtract(){
		DoubleMatrix m1 = new DoubleMatrix(2,2,2.0);
		DoubleMatrix m2 = new DoubleMatrix(2,2, 1.0);
		m1.subtract(new DoubleMatrix(2,2, 1.0));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void testSubtractWithDifferentNumberOfRows(){
		DoubleMatrix m1 = new DoubleMatrix(2,2, 2.0);
		m1.subtract(new DoubleMatrix(1,2, 1.0));
	}
	
	@Test
	public void testMultiply(){
		DoubleMatrix m1 = new DoubleMatrix(2,2,2.0);
		m1.multiply(2.0);
		
		assertEquals(m1, new DoubleMatrix(2,2, 4.0));
	}

	@Test
	public void testTransposeSquareMatrix(){
		double [][] m = {{2.0, 1.0},{3.0, 4.0}};
		double [][] mt = {{2.0, 3.0},{1.0, 4.0}};
		DoubleMatrix m1 = new DoubleMatrix(m);
		m1.transpose();
		
		assertEquals(m1, new DoubleMatrix(mt));
	}
	
	@Test
	public void testTransposeNonSquareMatrix(){
		double [][] m = {{1.0, 2.0},{3.0, 4.0}, {5.0, 6.0}};
		double [][] mt = {{1.0, 3.0, 5.0},{2.0, 4.0, 6.0}};
		DoubleMatrix m1 = new DoubleMatrix(m);
		
		m1.transpose();
		
		assertEquals(m1,new DoubleMatrix(mt));
	}
	
	@Test
	public void testNegate(){
		DoubleMatrix m1 = new DoubleMatrix(2,2,1.0);
		
		m1.negate();
		
		assertEquals(m1, new DoubleMatrix(2,2, -1.0));
		
	}
}
