package rationalnumbers;

public interface RationalNumber
{
	/*rv is the numerator of the reduced form of this rational numbers
	 *EX. since 5/3 is the reduced form of 10/6, (10/6).getNumerator() = 5
	 */
	public int getNumerator();
	
	/*rv is the numerator of the reduced form of this rational number
	 *EX: since 5/3 is the reduced form of 10/6, (10/6). getDenominator() = 3
	 */
	public int getDenominator();
	
	/*rv is the double equivalent of this rational number
	 *EX: (5/10).getValue() = 0.5
	 */
	public double getValue();
	
}
