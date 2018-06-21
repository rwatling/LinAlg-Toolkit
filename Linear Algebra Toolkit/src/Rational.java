/**
  * Copied most of the implementation from Introduction to Java Programming and Data Structures 11th Edition
  * by Y. Daniel Liang
  * 
  * @author: Robbie Watling
  * Summer 2018
  */

public class Rational extends Number implements Comparable<Rational>{
	/**
	 * Random serial
	 */
	private static final long serialVersionUID = 747594659068733876L;
	private long numerator;
	private long denominator;
	
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	
	public Rational (long num) {
		numerator = num;
		denominator = 1;
	}
	
	public Rational (long num, long denom) throws IllegalArgumentException{
		if (denom == 0)
			throw new IllegalArgumentException("Divide by zero error");
		
		long gcd = gcd(num, denom);
		numerator = (denom > 0 ? 1 : -1) * num / gcd;
		denominator = Math.abs(denom) / gcd;
	}
	
	
	private long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
		}
		
		return gcd;
	}
	
	public Rational getReciporical() {
		return new Rational(denominator, numerator);
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denominator;
	}
	
	public Rational add(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		
		return new Rational(n,d);
	}
	
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		
		return new Rational(n,d);
	}
	
	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		
		return new Rational(n,d);
	}
	
	//Divide by multiplying reciprocals
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.getNumerator();
		
		return new Rational(n,d);
	}
	
	public String toString() {
		if (numerator == 0)
			return "0";
		else if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}
	
	public boolean equals(Object other) {
		if ((this.subtract((Rational)other)).getNumerator() == 0)
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(Rational secondRational) {
		long subNumerator = this.subtract(secondRational).getNumerator();
		if (subNumerator > 0)
			return 1;
		else if (subNumerator < 0)
			return -1;
		else
			return 0;
	}

	@Override
	public double doubleValue() {
		return numerator * 1.0 / denominator;
	}

	@Override
	public float floatValue() {
		return (float) doubleValue();
	}

	@Override
	public int intValue() {
		return (int) doubleValue();
	}

	@Override
	public long longValue() {
		return (long) doubleValue();
	}
}