public class Vector extends RationalMatrix {
	/*
	 * Although a vector is typically represented vertically, we will be representing this vector as
	 * a single dimensional array
	 */
	private Rational[] vectorArray;
	
	public Vector() {
		vectorArray = new Rational[1];
		vectorArray[0] = new Rational(0,1);
	}

	/*
	 * Similar implementation of constructor from Rational Matrix
	 */
	public Vector(String[] stringArray) {
		for(int j = 0; j < stringArray.length; j++) {
			String tempString = stringArray[j];
			if(tempString.contains("/")) {
				int vinculumIndex = tempString.indexOf("/");
				vectorArray[j] = new Rational(Integer.parseInt(tempString.substring(0,vinculumIndex)), Integer.parseInt(tempString.substring(vinculumIndex + 1)));
			}
		}
	}
	
	/*
	 * Overloaded getCell method
	 */
	public Rational getCell(int row) {
		return vectorArray[row-1]; 
	}
}