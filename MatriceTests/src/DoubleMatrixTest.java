import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DoubleMatrixTest {
	
	@Test
	public void testAdd(){
		DoubleMatrix m1 = new DoubleMatrix(2,2, 2.0);
		DoubleMatrix m2 = new DoubleMatrix(2,2, 3.0);
		m1.add(new DoubleMatrix(2,2, 1.0));
		
		assertEquals(m1, m2);
	}
	
	@Test(expected = IncompatibleMatrixException.class)
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
	
	@Test(expected = IncompatibleMatrixException.class)
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
		
		DoubleMatrix m1 = new DoubleMatrix(2,2);
		
		m1.setAt(0, 0, 2.0);
		m1.setAt(0, 1, 1.0);
		m1.setAt(1, 0, 3.0);
		m1.setAt(1, 1, 4.0);
		
		DoubleMatrix m2 = new DoubleMatrix(2,2);
		
		m2.setAt(0,  0, 2.0);
		m2.setAt(0, 1, 3.0);
		m2.setAt(1,0, 1.0);
		m2.setAt(1, 1, 4.0);
		
		m1.transpose();
		
		assertEquals(m1, m2);
	}
	
	@Test
	public void testTransposeNonSquareMatrix(){
		DoubleMatrix m1 = new DoubleMatrix(3,2);
		
		m1.setAt(0, 0, 1.0);
		m1.setAt(0, 1, 2.0);
		m1.setAt(1, 0, 3.0);
		m1.setAt(1, 1, 4.0);
		m1.setAt(2, 0, 5.0);
		m1.setAt(2, 1, 6.0);
		
		DoubleMatrix m2 = new DoubleMatrix(2,3);
		
		m2.setAt(0, 0, 1.0);
		m2.setAt(0, 1, 3.0);
		m2.setAt(0, 2, 5.0);
		m2.setAt(1, 0, 2.0);
		m2.setAt(1, 1, 4.0);
		m2.setAt(1, 2, 6.0);

		
		m1.transpose();
		
		assertEquals(m1, m2);

	}
	
	@Test
	public void testNegate(){
		DoubleMatrix m1 = new DoubleMatrix(2,2,1.0);
		
		m1.negate();
		
		assertEquals(m1, new DoubleMatrix(2,2, -1.0));
		
	}
}
