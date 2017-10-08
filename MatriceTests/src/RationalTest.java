import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;

public class RationalTest {

	
	@BeforeClass
	public static void setUp(){	
		System.setSecurityManager(new SystemExitSecurityManager());
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void zeroDenominator(){
		new Rational(2,0);
	}
	
	@Test 
	public void testNormalize(){
		assertEquals(new Rational(2,4), new Rational(1,2));
	}
	
	@Test
	public void testNegativeDenominator(){
		assertEquals(new Rational(-1,2), new Rational(1, -2));
	}
	
	@Test 
	public void testAdd(){
		Rational r = new Rational(1,2);
		r.add(new Rational(1,2));
		assertEquals(r, new Rational(1));
	}
	
	@Test 
	public void testAddZero(){
		Rational r = new Rational(1,2);
		r.add(new Rational(0));
		assertEquals(r, new Rational(1,2));
	}
	
	@Test 
	public void testAddNegative(){
		Rational r = new Rational(3, 2);
		r.add(new Rational(-1 , 2));
		assertEquals(r, new Rational(1));
	}
		
	@Test
	public void testAddWholeNumber(){
		Rational r = new Rational(1,2);
		r.add(new Rational(1));
		assertEquals(r, new Rational(3,2));
	}
	
	@Test
	public void testSubtract(){
		Rational r = new Rational(3 , 2);
		r.subtract(new Rational(1 , 2));
		assertEquals(r, new Rational(1));
	}
	
	@Test
	public void testSubtractZero(){
		Rational r = new Rational(1,2);
		r.subtract(new Rational(0));
		assertEquals(r, new Rational(1,2));
	}
	
	@Test
	public void testSubtractFromZero(){
		Rational r = new Rational(0);
		r.subtract(new Rational(1,2));
		assertEquals(r, new Rational(-1, 2));
	}
	
	@Test
	public void testSubtractWholeNumber(){
		Rational r = new Rational(3,2);
		r.subtract(new Rational(1));
		assertEquals(r, new Rational(1,2));
	}
	
	@Test
	public void testMultiply(){
		Rational r = new Rational(1,2);
		r.multiply(new Rational(1,2));
		assertEquals(r, new Rational(1,4));
	}
	
	@Test
	public void testMultiplyZero(){
		Rational r = new Rational(1,2);
		Rational zero = new Rational(0);
		r.multiply(zero);
		assertEquals(r, zero);
	}
	
	@Test
	public void testMuliplyNegative(){
		Rational r = new Rational(1,2);
		r.multiply(new Rational(-1));
		assertEquals(r, new Rational(-1,2));
	}
	@Test 
	public void testMultiplyByWholeNumber(){
		Rational r = new Rational(1,2);
		r.multiply(new Rational(3));
		assertEquals(r, new Rational(3,2));
	}
	@Test
	public void testMultiplyByDenominator(){
		Rational r = new Rational(1,2);
		r.multiply(new Rational(2));
		assertEquals(r, new Rational(1));
	}
	
	@Test
	public void testDivide(){
		Rational r = new Rational(1,2);
		r.divide(new Rational(1,3));
		assertEquals(r, new Rational(3,2));
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void testDivideByZero(){
		Rational r = new Rational(1,2);
		r.divide(new Rational(0));
	}
	
	@Test
	public void testDivideZero(){
		Rational r = new Rational(0);
		r.divide(new Rational(1,2));
		assertEquals(r, new Rational(0));
	}
	
	@Test
	public void testDivideByWholeNumber(){
		Rational r = new Rational(1,2);
		r.divide(new Rational(2));
		assertEquals(r, new Rational(1,4));
	}
	
	@Test 
	public void testDividePositiveByNegative(){
		Rational r = new Rational(1,2);
		r.divide(new Rational(-1));
		assertEquals(r, new Rational(-1,2));
	}
	
	@Test
	public void testDivideNegativeByNegative(){
		Rational r = new Rational(-1,2);
		r.divide(new Rational(-1));
		assertEquals(r, new Rational(1,2));
	}
	
	@Test
	public void testNegate(){
		Rational r = new Rational(1,2);
		r.negate();
		assertEquals(r, new Rational(-1,2));
	}
	
	@Test
	public void testNegateZero(){
		Rational r = new Rational(0);
		r.negate();
		assertEquals(r, new Rational(0));
	}
	
	@Test
	public void testNegateWholeNumber(){
		Rational r = new Rational(1);
		r.negate();
		assertEquals(r, new Rational(-1));
	}
		
	@Test
	public void testNegateNegative(){
		Rational r = new Rational(1,2);
		r.negate();
		assertEquals(r, new Rational(-1,2));
	}
	
	@Test
	public void testReciprocate(){
		Rational r = new Rational(3,2);
		r.reciprocate();
		assertEquals(r, new Rational(2,3));
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void testReciprocateZero(){
		Rational r = new Rational(0);
		r.reciprocate();
	}
	
	@Test
	public void testReciprocateNegative(){
		Rational r = new Rational(-3, 2);
		r.reciprocate();
		assertEquals(r, new Rational(-2, 3));
	}
	
	@Test
	public void testReciprocateOne(){
		Rational r = new Rational(1);
		r.reciprocate();
		assertEquals(r, new Rational(1));
	}
	
	@Test
	public void testReciprocateWholeNumber(){
		Rational r = new Rational(2);
		r.reciprocate();
		assertEquals(r, new Rational(1,2));
	}
	
	@Test 
	public void testSetDenominator(){
		Rational r = new Rational(1,2);
		r.setDenominator(3);
		assertEquals(r.getDenominator(), 3);
	}
	
	@Test(expected = SystemExitSecurityException.class)
	public void testSetDenominatorToZero(){
		Rational r = new Rational(1,2);
		r.setDenominator(0);
	}
	
	@Test
	public void testSetDenominatorToNegative(){
		Rational r = new Rational(1,2);
		r.setDenominator(-2);
		assertEquals(r.getDenominator(), 2);
		assertEquals(r.getNumerator(), -1);
	}
	
	@Test
	public void testSetDenominatorNormalization(){
		Rational r = new Rational(2,3);
		r.setDenominator(4);
		assertEquals(r.getDenominator(), 2);
		assertEquals(r.getNumerator(), 1);
	}
	
	@Test
	public void testSetNumerator(){
		Rational r = new Rational(1,2);
		r.setNumerator(3);
		assertEquals(r.getNumerator(), 3);
	}
	
	@Test
	public void testSetNumeratorToZero(){
		Rational r = new Rational(1,2);
		r.setNumerator(0);
		assertEquals(r.getNumerator(),0);
		assertEquals(r.getDenominator(), 1);
	}
	
	@Test
	public void testSetNumeratorNormalization(){
		Rational r = new Rational(1,2);
		r.setNumerator(2);
		assertEquals(r.getNumerator(), 1);
		assertEquals(r.getDenominator(), 1);
	}
			
}
