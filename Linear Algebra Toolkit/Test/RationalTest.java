import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RationalTest {
	Rational r1;
	Rational r2;
	Rational r3;
	Rational r4;
	
	@Before
	public void setup() {
		r1 = new Rational(4,2);
		r2 = new Rational(2,3);
		r3 = new Rational();
		r4 = new Rational(4,6);
	}

	@Test
	public void testAdd() {
		assertEquals(r1.add(r2).toString(), "8/3");
	}

	@Test
	public void testSubtract() {
		assertEquals(r1.subtract(r2).toString(),"4/3");
	}

	@Test
	public void testMultiply() {
		assertEquals(r1.multiply(r2).toString(),"4/3");
	}

	@Test
	public void testDivide() {
		assertEquals(r1.divide(r2).toString(),"3");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testException() {
		r1 = new Rational(1,0);
	}
	
	@Test
	public void testToString() {
		assertEquals("0", r3.toString());
	}
	
	@Test
	public void testEquals() {
		assertTrue(r4.equals(r2));
	}
	
	@Test
	public void testReciporical() {
		assertEquals("3/2", r2.getReciporical().toString());
	}
}
