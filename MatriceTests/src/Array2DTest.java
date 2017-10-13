import org.junit.*;
import static org.junit.Assert.*; 
public class Array2DTest {
	
	
	@Test
	public void testInitialize() {
		Array2D<Rational> a2D = new Array2D<Rational>(2,2);
		
		for(int i = 0; i < a2D.rows(); i++) {
			for(int j = 0; j < a2D.columns(); j++) {
				assertNull(a2D.get(i, j));
			}
			
		}
		
		assertEquals(a2D.rows(), 2);
		assertEquals(a2D.columns(), 2);
		
	}

}
