/*Amanda Ortiz 
 * Fall 2016 - Algorithms - Kart 
 * Rational Numbers to Continued Fractions
 */
package rationalnumbers;

import java.util.ArrayList;
import java.util.List;

public class ContinuedFractionUtils_Ortiz
{
	private ContinuedFractionUtils_Ortiz()
	{
		throw new RuntimeException("DO NOT INSTANTIATE!");
	}

	/*PRE: denominator != 0
	 * POST: rv is int[] of coefficients for given numerator and denominator
	 * EX: 4/3 => {1,3}
	 * EX: -4/3 => {-2,1,2}
	 * EX: 4/-3 => {-2,1,2}
	 */
	public static int[] computeCoefficients(int numerator, int denominator)
	{
		assert denominator != 0: "DENOMINATOR != 0 !";

		List<Integer> listOfContinuedFractionIntegers = new ArrayList<Integer>();
		int coefficientForList = 0;
		int remainder = 0;

		// if numerator * denominator < 0, adjust: negate abs(numerator) and abs(denominator)
		if (numerator * denominator < 0)
		{
			numerator = (-(Math.abs(numerator)));
			denominator = Math.abs(denominator);
		}
		
		/*following lines ensure that the first number in the coefficient 
		 * list is the only negative in the list, and presets numerator and 
		 * denominator to correct values 
		 */
		coefficientForList = Math.floorDiv(numerator, denominator);
		listOfContinuedFractionIntegers.add(coefficientForList);

		remainder = Math.floorMod(numerator, denominator);
		numerator = denominator;
		denominator = remainder;

		/*while loop iterates through continued fraction math
		 * while remainder > 0  
		 *ex: final iteration would look like : 
		 *...     1
		 * 	7 +  ---
		 * 	      2 --> final remainder
		 */
		while(remainder > 0)
		{
			coefficientForList = Math.floorDiv(numerator, denominator);

			remainder = numerator % denominator;
			numerator = denominator;
			denominator = remainder;

			listOfContinuedFractionIntegers.add(coefficientForList);

		}

		/* putting list of continuedFractionIntegers into an array
		 * array will be returned
		 * array contains coeffients from continued fraction math
		 */
		int[] arrayOfContinuedFractionIntegers = new int[listOfContinuedFractionIntegers.size()];
		for(int i = 0; i < listOfContinuedFractionIntegers.size(); i++)
		{
			arrayOfContinuedFractionIntegers[i] = listOfContinuedFractionIntegers.get(i);
			
		}


		return arrayOfContinuedFractionIntegers;
	}

}
