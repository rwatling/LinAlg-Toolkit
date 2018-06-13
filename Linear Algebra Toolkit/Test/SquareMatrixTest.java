import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquareMatrixTest{
	String [][] stringMatrix;
	RationalMatrix myRationalMatrix;
	
	@Before
	public void setup() {
		stringMatrix = new String[3][3];
		int k = 0;
		for (int i = 0; i < stringMatrix.length; i++) {
			for (int j = 0; j < stringMatrix[0].length; j++) {
				stringMatrix[i][j] = k + "/2";
				k++;
			}
		}
		myRationalMatrix = new RationalMatrix(stringMatrix);
	}
	
	@Test
	public void testSetupAndGet() {
		assertEquals("0", myRationalMatrix.getCell(1, 1).toString());
		assertEquals("1/2", myRationalMatrix.getCell(1, 2).toString());
		assertEquals("1", myRationalMatrix.getCell(1, 3).toString());
		assertEquals("3/2", myRationalMatrix.getCell(2, 1).toString());
		assertEquals("3", myRationalMatrix.getCell(3, 1).toString());
	}
	
	@Test 
	public void testGetInvalid() {
		assertEquals(null, myRationalMatrix.getCell(0, 0));
		assertEquals(null, myRationalMatrix.getCell(4, 1));
		assertEquals(null, myRationalMatrix.getCell(1, 4));
		assertEquals(null, myRationalMatrix.getCell(4, 4));
		assertEquals(null, myRationalMatrix.getCell(-1, 3));
	}
	
	@Test
	public void rowSwap() {
		myRationalMatrix.rowSwap(1, 2);
		assertEquals("3/2", myRationalMatrix.getCell(1, 1).toString());
		assertEquals("2", myRationalMatrix.getCell(1, 2).toString());
		assertEquals("5/2", myRationalMatrix.getCell(1, 3).toString());
		assertEquals("0", myRationalMatrix.getCell(2, 1).toString());
		assertEquals("3", myRationalMatrix.getCell(3, 1).toString());
	}
}