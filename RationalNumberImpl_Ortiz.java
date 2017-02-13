/*Amanda Ortiz 
 * Fall 2016 - Algorithms - Kart 
 * Rational Numbers to Continued Fractions
 */
package rationalnumbers;

import java.util.ArrayList;
import java.util.List;

public class RationalNumberImpl_Ortiz implements RationalNumber 
{
	private int[] continuedFractionTerms;
	
	
	public RationalNumberImpl_Ortiz(List<Integer> continuedFractionTerms)
	{
		
		this.continuedFractionTerms = new int[continuedFractionTerms.size()];
		for(int i = 0; i < continuedFractionTerms.size(); i++)
		{
			this.continuedFractionTerms[i] = continuedFractionTerms.get(i);
		}

	}

	
	/*rv is the numerator of the reduced form of this rational numbers
	 *EX. since 5/3 is the reduced form of 10/6, (10/6).getNumerator() = 5
	 */
	public int getNumerator()
	{
		int numerator = 0;
		int [] rationalNumberAsArray = continuedFractionTermsToFraction(this.continuedFractionTerms);
	
		numerator = rationalNumberAsArray[0];
		
		return numerator;
	}

	
	/*rv is the numerator of the reduced form of this rational number
	 *EX: since 5/3 is the reduced form of 10/6, (10/6). getDenominator() = 3
	 */
	public int getDenominator()
	{
		int denominator = 0;
		int [] rationalNumberAsArray = continuedFractionTermsToFraction(this.continuedFractionTerms);
		
		denominator = rationalNumberAsArray[1];
		
		return denominator;
	}

	
	
	/*rv is the double equivalent of this rational number
	 *EX: (5/10).getValue() = 0.5
	 */
	public double getValue()
	{
		double value = 0;
		int [] rationalNumberAsArray = continuedFractionTermsToFraction(this.continuedFractionTerms);
		int numerator = 0;
		int denominator = 0;
		numerator = rationalNumberAsArray[0];
		denominator = rationalNumberAsArray[1];

		value = (0.0 + numerator)/denominator; //
		
		return value;
	}
	

	
	public String toString()
	{
		return RationalNumbersUtils.toString(this);
	}
	
	
	/*PRE: continuedFractionTerms.length != 0;
	 *POST: continuedFractionTermsAsFraction[1] != 0;
	 *POST: if(continuedFractionTerms.length == 1 && continuedFractionTermsAsFraction[0] == 0) =>
	 *		numerator == 0 && denominator == 1
	 *POST: denominator > 0
	 *POST: Fraction is returned in reduced form
	 */
	private int[] continuedFractionTermsToFraction(int[] continuedFractionTerms)
	{
		assert continuedFractionTerms.length != 0: "EMPTY LIST => CAN NOT CREATE NUMERATOR AND DENOMINATOR";
		int[] continuedFractionTermsAsFraction = new int[2];
		List<Integer> numeratorList = new ArrayList<Integer>();
		List<Integer> denominatorList = new ArrayList<Integer>();
		int numerator = continuedFractionTerms[continuedFractionTerms.length-1];
		int denominator = 1;
		int listIndexTracker = 0;
		
		numeratorList.add(numerator);
		denominatorList.add(denominator);
	    
		
		
	    for(int i = continuedFractionTerms.length-1; i > 0; i--)
		{
	    	
	    	
	    	numerator = (continuedFractionTerms[i-1]*numeratorList.get(listIndexTracker))+denominatorList.get(listIndexTracker);
	    	denominator = numeratorList.get(listIndexTracker);
	    	
	    	numeratorList.add(numerator);
	    	denominatorList.add(denominator);
	    	
	    	listIndexTracker++;
		}
	  
	    if (numerator * denominator < 0)
	    {
	    	numerator = (-(Math.abs(numerator)));
	    	denominator = Math.abs(denominator);
	    }
	    
	    
		continuedFractionTermsAsFraction[0] = numeratorList.get(numeratorList.size()-1);
		continuedFractionTermsAsFraction[1] = denominatorList.get(denominatorList.size()-1);
		
		assert continuedFractionTermsAsFraction[1] != 0;
		
		if(continuedFractionTerms.length == 1 && continuedFractionTermsAsFraction[0] == 0)
		{
			assert numerator == 0;
			assert denominator == 1;
		}
		
		assert denominator > 0;
		return continuedFractionTermsAsFraction;
		
	}
}
